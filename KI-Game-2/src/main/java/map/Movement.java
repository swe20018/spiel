package map;

import communication.FortStatevalues;
import communication.PlayerStatevalues;
import communication.TresureStatevalues;
import messages.MoveValues;
import messages.Terraintype;

public class Movement {

	private int avatarLine; /* Line Position of Avatar */
	private int avatarColumn; /* column ... */
	private int newDestination;
	private int avatarPosition;
	private LocalMap map = null; /* map where we walk */
	private int lastMoves[]; /* to find back already walked ways - ariadne's thread */
	private boolean movingBack = false;

	private static int graph[][] = null; /* first param = from, second = to */
	private static boolean hasBeenVisited[] = new boolean[64];

	public Movement() {

		lastMoves = new int[64];
		for (int i = 0; i < 64; i++)
			lastMoves[i] = -1;
	}

	/**
	 * 
	 * @param map
	 *            - the map got from Server
	 * @param hasCollectedTreasure
	 *            - if false: Search for treasure, if true: search for castle
	 * @return
	 */

	public MoveValues doMove(LocalMap map, boolean hasCollectedTreasure) {

		/* where am i now? */

		this.map = map;
		avatarLine = map.getAvatarPosition().getLine();
		avatarColumn = map.getAvatarPosition().getColumn();
		
		newDestination = -1;
		avatarPosition = avatarLine * 8 + avatarColumn;

		/* build graph */

		if (null == graph) {

			graph = new int[64][64];

			for (int line = 0; line < 8; line++) {
				for (int column = 0; column < 8; column++) {

					for (int l = -1; l < 2; l++) {
						for (int c = -1; c < 2; c++) {
							if ((l == c) || (l == -c)) {
								/* diagonal */
								continue;
							}

							int from = (line * 8) + column;
							int to = ((line + l) * 8) + column + c;

							if (!isPositionOk(line + l, column + c))
								continue;

							switch (map.getField(line + l, column + c).getType()) {
							case WATER:
							case EMPTY:
								/* Cannot go there */
								graph[from][to] = 0;
								break;
							case MOUNTAIN:
								/* hard to go there */
								graph[from][to] = 2;
								break;
							case GRASS:
								/* easy to go there */
								graph[from][to] = 1;
								break;
							}

							hasBeenVisited[from] = false;
						}
					}
				}
			}
		}

		map.getField(avatarLine, avatarColumn).setBeenVisited();

		/* idea behind moving: Go everywhere */
		if (hasCollectedTreasure) {
			/* search for enemies castle */

			newDestination = isFortAround();
		} else {
			/* search for treasure */

			newDestination = isTreasureAround();
		}

		/* found short way ? */

		if (newDestination < 0) {

			if (movingBack) {

				/* could turn ? */

				newDestination = justMove(avatarPosition);

				if (newDestination >= 0) {
					/* found new way */
					movingBack = false;
				} else {
					/* continue walking back */
					deleteLastMove();
					newDestination = goTo(avatarPosition, getLastMove());
				}
			} else {

				/* no */
				newDestination = justMove(avatarPosition);
				/* found new step */
				if (newDestination < 0) {
					movingBack = true;
					deleteLastMove();
					newDestination = goTo(avatarPosition, getLastMove());

				}
			}
		}

		/* have been everywhere, walk back */

		if (!movingBack)
			addLastMove(newDestination);

		hasBeenVisited[newDestination] = true;

		moveAvatar(newDestination);
		/* avatarLine = map.getAvatarPosition().getLine(); */
		/* avatarColumn = map.getAvatarPosition().getColumn(); */

		System.out.println ("Move: " + avatarLine + "/" + avatarColumn + " " + newDestination / 8 + "/" + newDestination % 8);
		return serverMoveValue(newDestination);
	}

	/**
	 * go from one position to next
	 */
	private int goTo(int from, int to) {

		/* find way to destination */
		/* direct way ? */
		
		if ((from < 0) | (from > 7))
			return -1;
		if ((to < 0) | (to > 7))
			return -1;

		if (graph[from][to] > 0) {
			/* yes, move there */

			return to;
		} else {

			/* find best way */

			for (int dest = 0; dest < to; dest++) {

				if (graph[from][dest] > 0) {
					/* possible way */
					return goTo(dest, to);
				}
			}
			return -1;
		}
	}

	/**
	 * add the last move to already walked path - just to be sure to find back
	 * 
	 * @param move
	 */

	private void addLastMove(int move) {
		for (int i = 0; i < 64; i++) {
			if (lastMoves[i] == -1) {
				/* empty */
				lastMoves[i] = move;
				return;
			}
		}
		System.out.println("verkoffert!");
		System.exit(0);
	}

	/**
	 * get the last move to already walked path - to continue
	 * 
	 * @param move
	 */

	private int getLastMove() {
		for (int i = 0; i < 64; i++) {
			if (lastMoves[i] == -1) {
				/* found the last one */
				if (i > 0) {
					return (lastMoves[i - 1]);
				} else {
					return -1;
				}
			}
		}
		return -1;
	}

	/**
	 * delete the last move to already walked path - we are walking back
	 * 
	 * @param move
	 */

	private void deleteLastMove() {
		for (int i = 0; i < 64; i++) {
			if (lastMoves[i] == -1) {
				/* found the last one */
				if (i > 0) {
					lastMoves[i - 1] = -1;
				}
				return;
			}
		}
		System.out.println("verkoffert!");
		System.exit(0);
	}

	/**
	 * check if position value inside borders
	 * 
	 * @return true or false
	 */

	private boolean isPositionOk(int line, int column) {

		if ((column < 0) || (column > 7))
			return false;
		if ((line < 0) || (line > 7))
			return false;

		return true;
	}

	/**
	 * Check, if somewhere around is the treasure. If yes, go there
	 * 
	 * @return Direction or null
	 */

	private int isTreasureAround() {

		for (int l = -1; l < 2; l++) {
			for (int c = -1; c < 2; c++) {

				if (!isPositionOk(avatarLine + l, avatarColumn + c))
					continue;
				else if (map.getField(avatarLine + l, avatarColumn + c)
						.getTreasureState() == TresureStatevalues.MY_TRESURE_IS_PLACED_HERE) {

					return goTo(avatarPosition, ((avatarLine + l) * 8) + avatarColumn + c);
				}
			}
		}
		return -1;
	}

	/**
	 * Check, if somewhere around is the enemy's castle. If yes, go there
	 * 
	 * @return Direction or null
	 */

	private int isFortAround() {

		for (int l = -1; l < 2; l++) {
			for (int c = -1; c < 2; c++) {

				if (!isPositionOk(avatarLine + l, avatarColumn + c))
					continue;
				else if (map.getField(avatarLine + l, avatarColumn + c)
						.getFortState() == FortStatevalues.ENEMY_FORT_PRESENT) {

					return goTo(avatarPosition, ((avatarLine + l) * 8) + avatarColumn + c);
				}
			}
		}
		return -1;
	}

	/**
	 * move the avatar
	 * 
	 * @param newPosition
	 * 
	 * @return MoveValue or null, of program error
	 */

	private void moveAvatar(int newPosition) {

		/* delete former Position */
		if (PlayerStatevalues.BOTH_PLAYER_POSITION == map.getField(avatarLine, avatarColumn).getPlayerState()) {
			map.getField(avatarLine, avatarColumn).setPlayerState(PlayerStatevalues.ENEMY_PLAYER_POSITION);
		} else {
			map.getField(avatarLine, avatarColumn).setPlayerState(PlayerStatevalues.NO_PLAYER_PRESENT);
		}

		map.setAvatarPosition(new Position(newPosition / 8, newPosition % 8));
		/* set new Position */
		if (PlayerStatevalues.ENEMY_PLAYER_POSITION == map.getField(newPosition / 8, newPosition % 8)
				.getPlayerState()) {
			map.getField(newPosition / 8, newPosition % 8).setPlayerState(PlayerStatevalues.BOTH_PLAYER_POSITION);
		} else {
			map.getField(newPosition / 8, newPosition % 8).setPlayerState(PlayerStatevalues.MY_POSITION);
		}
		return;
	}

	/**
	 * translate own coordinates to server-understandable values
	 * 
	 * @param line
	 * @param column
	 * @return MoveValue or null, of program error
	 */

	private MoveValues serverMoveValue(int newPosition) {

		/* At Server Line = Y, Column = x */

		int newLine = newPosition / 8;
		int newColumn = newPosition % 8;
		
		System.out.println("From (X/Y) " + avatarColumn + "/" + avatarLine + " to " + newColumn + "/" + newLine);

		if ((newLine - avatarLine) > 0)
			return MoveValues.DOWN;
		if ((newLine - avatarLine) < 0)
			return MoveValues.UP;
		if ((newColumn - avatarColumn) > 0)
			return MoveValues.RIGHT;
		if ((newColumn - avatarColumn) > 0)
			return MoveValues.LEFT;

		return null;
	}

	/**
	 * just move
	 * 
	 * idea Ariadne
	 * 
	 * as long as walking (so check surrounding for treasure and castle)
	 * 
	 * @return move
	 */

	public int justMove(int from) {

		for (int dest = 0; dest < 64; dest++) {

			if ((graph[from][dest] > 0) && !hasBeenVisited[dest]) {

				return (dest);
			}
		}
		return -1;
	}
}
