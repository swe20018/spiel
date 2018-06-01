package map;

import messages.Terraintype;
import static java.lang.Math.*;
import java.util.Random;

import communication.FortStatevalues;
import communication.PlayerStatevalues;

public class LocalMap {

	private Field[][] field;
	private Position avatarPosition;

	private Position castlePosition;
	private Position treasurePosition;
	private Position firstEnemyPosition;

	public LocalMap() {

		this.field = new Field[8][8];
		avatarPosition = new Position();
		castlePosition = new Position();
		treasurePosition = new Position();
		firstEnemyPosition = null;

		for (int line = 0; line < 8; line++)
			for (int column = 0; column < 8; column++)
				field[line][column] = new Field();
	}

	/**
	 * Check if map is valid
	 * 
	 * @return the field
	 */
	public boolean checkLocalMap() {

		/* check borders */

		int borderWaterCountTop = 0; /* maximum of 3 */
		int borderWaterCountBottom = 0; /* maximum of 3 */

		for (int column = 0; column < 8; column++) {

			if (field[0][column].getType() == Terraintype.WATER)
				borderWaterCountTop++;
			if (field[3][column].getType() == Terraintype.WATER)
				borderWaterCountBottom++;
		}

		if ((borderWaterCountTop > 3) | (borderWaterCountBottom > 3))
			return false;

		/* check fieldtypes */

		int mountainCount = 0; /* minimum of 3 */
		int waterCount = 0; /* minimum of 4 */
		int grassCount = 0; /* minimum of 15 */

		for (int line = 0; line < 8; line++)
			for (int column = 0; column < 8; column++) {

				switch (field[line][column].getType()) {

				case GRASS:
					grassCount++;
					break;
				case WATER:
					waterCount++;
					break;
				case MOUNTAIN:
					mountainCount++;
					break;
				case EMPTY:
					break;
				}
			}

		if ((mountainCount < 3) | (waterCount < 4) | (grassCount < 15))
			return false;

		/* Find islands */

		for (int line = 0; line < 8; line++) {
			for (int column = 0; column < 8; column++) {

				if ((field[line][column].getType() == Terraintype.MOUNTAIN)
						|| (field[line][column].getType() == Terraintype.GRASS)) {

					/* Could be an island, check surrounding */

					if ((field[min(line + 1, 3)][column].getType() == Terraintype.WATER)
							& (field[max(line - 1, 0)][column].getType() == Terraintype.WATER)
							& (field[line][min(column + 1, 7)].getType() == Terraintype.WATER)
							& (field[line][max(column - 1, 7)].getType() == Terraintype.WATER)) {
						/* island! */
						return false;
					}
					if ((line == 0) & (field[1][column].getType() == Terraintype.WATER)
							& (field[0][min(column + 1, 7)].getType() == Terraintype.WATER)
							& (field[0][max(column - 1, 7)].getType() == Terraintype.WATER)) {
						/* island at top border */
						return false;
					}
					if ((line == 3) & (field[2][column].getType() == Terraintype.WATER)
							& (field[3][min(column + 1, 7)].getType() == Terraintype.WATER)
							& (field[3][max(column - 1, 7)].getType() == Terraintype.WATER)) {
						/* island at bottom border */
						return false;
					}
					if ((column == 0) & (field[line][1].getType() == Terraintype.WATER)
							& (field[min(line + 1, 3)][0].getType() == Terraintype.WATER)
							& (field[max(line - 1, 3)][0].getType() == Terraintype.WATER)) {
						/* island at right border */
						return false;
					}
					if ((column == 7) & (field[line][6].getType() == Terraintype.WATER)
							& (field[min(line + 1, 3)][7].getType() == Terraintype.WATER)
							& (field[max(line - 1, 3)][7].getType() == Terraintype.WATER)) {
						/* island at left border */
						return false;
					}
				}
			}
		}

		/* find diagnoal water-lines */

		for (int column = 0; column < 8; column++) {
			if (field[0][column].getType() == Terraintype.WATER) {

				if ((field[1][max(0, column - 1)].getType() == Terraintype.WATER)
						|| (field[1][column].getType() == Terraintype.WATER)
						|| (field[1][min(7, column + 1)].getType() == Terraintype.WATER)) {

					if ((field[2][max(0, column - 1)].getType() == Terraintype.WATER)
							|| (field[2][column].getType() == Terraintype.WATER)
							|| (field[2][min(7, column + 1)].getType() == Terraintype.WATER)) {
		
						if ((field[3][max(0, column - 1)].getType() == Terraintype.WATER)
								|| (field[3][column].getType() == Terraintype.WATER)
								|| (field[3][min(7, column + 1)].getType() == Terraintype.WATER)) {
									
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	/**
	 * Generate new (half) map content
	 * 
	 * @param which
	 *            line to start
	 */
	public void generateHalfMap(int initLine) {

		/* initialize with GRASS */

		for (int line = initLine; line < initLine + 4; line++)
			for (int column = 0; column < 8; column++)
				field[line][column].setType(Terraintype.GRASS);

		/* set own castle to somewhere */

		setCastlePosition(new Position(initLine + 2, 0));
		setAvatarPosition(new Position(initLine + 2, 0));
		field[initLine + 2][0].setFortState(FortStatevalues.MY_FORT_PRESENT);
		field[initLine + 2][0].setPlayerState(PlayerStatevalues.MY_POSITION);

		/* add static 5 MOUNTAIN and 5 WATER */

		Random rnd = new Random();

		int counter;

		for (counter = 0; counter < 5;) {
			int linePos = initLine + rnd.nextInt(4);
			int columnPos = rnd.nextInt(8);

			if (field[linePos][columnPos].getFortState() == FortStatevalues.MY_FORT_PRESENT)
				continue;
			if (field[linePos][columnPos].getType() != Terraintype.GRASS)
				continue;

			field[linePos][columnPos].setType(Terraintype.MOUNTAIN);

			counter++;
		}
		for (counter = 0; counter < 5;) {

			int linePos = initLine + rnd.nextInt(4);
			int columnPos = rnd.nextInt(8);

			if (field[linePos][columnPos].getFortState() == FortStatevalues.MY_FORT_PRESENT)
				continue;
			if (field[linePos][columnPos].getType() != Terraintype.GRASS)
				continue;

			field[linePos][columnPos].setType(Terraintype.WATER);

			counter++;
		}
		return;
	}

	/**
	 * showMap in CLI
	 * 
	 * @param avatar
	 *            for which to be shown
	 */
	public void showLocalMap() {

		/* top line */
		for (int column = 0; column < 8; column++) {
			System.out.print("+------");
		}
		System.out.println("+");

		for (int line = 0; line < 8; line++) {
			for (int column = 0; column < 8; column++) {
				System.out.print("|" + field[line][column].showField());
			}
			System.out.println("|");
			/* between and finishing line */
			for (int column = 0; column < 8; column++) {
				System.out.print("+------");
			}
			System.out.println("+");
		}

		return;
	}

	/**
	 * when treasure found, it is necessary to walk around again, even where I have
	 * been already
	 */

	public void clearVisitState() {

		for (int line = 0; line < 8; line++)
			for (int column = 0; column < 8; column++)
				field[line][column].setNotBeenVisited();
	}

	/**
	 * @param Return
	 *            Field from single Position
	 * @return the field
	 */
	public Field getField(Position position) {
		return field[position.getLine()][position.getColumn()];
	}

	/**
	 * @param field
	 *            the field to set
	 * @param position
	 *            of the field
	 */
	public void setField(Field field, Position position) {
		this.field[position.getLine()][position.getColumn()] = field;
	}

	/**
	 * @param Return
	 *            Field from single Position
	 * @return the field
	 */
	public Field getField(int line, int column) {
		return field[line][column];
	}

	/**
	 * @param field
	 *            the field to set
	 * @param position
	 *            of the field
	 */
	public void setField(int line, int column, Field field) {
		this.field[line][column] = field;
	}

	/**
	 * @return the castlePosition
	 */
	public Position getCastlePosition() {
		return castlePosition;
	}

	/**
	 * @param castlePosition
	 *            the castlePosition to set
	 */
	public void setCastlePosition(Position castlePosition) {
		this.castlePosition = castlePosition;
	}

	/**
	 * @return the treasurePosition
	 */
	public Position getTreasurePosition() {
		return treasurePosition;
	}

	/**
	 * @param treasurePosition
	 *            the treasurePosition to set
	 */
	public void setTreasurePosition(Position treasurePosition) {
		this.treasurePosition = treasurePosition;
	}

	/**
	 * @return the avatarPosition
	 */
	public Position getAvatarPosition() {
		return avatarPosition;
	}

	/**
	 * @param avatarPosition
	 *            the avatarPosition to set
	 */
	public void setAvatarPosition(Position avatarPosition) {
		this.avatarPosition = avatarPosition;
	}

	/**
	 * @return the enemyPosition
	 */
	public Position getFirstEnemyPosition() {
		return firstEnemyPosition;
	}

	/**
	 * @param enemyPosition
	 *            the enemyPosition to set
	 */
	public void setFirstEnemyPosition(Position firstEnemyPosition) {
		this.firstEnemyPosition = firstEnemyPosition;
	}
}
