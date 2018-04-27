package map;

import movement.*;

public class Map {

	private Field[][] field;
	private Position[] avatarPosition;
	private Position[] castlePosition;
	private Position[] treasurePosition;

	public Map() {

		Field[][] field = new Field[8][8];
		avatarPosition = new Position[2];
		castlePosition = new Position[2];
		treasurePosition = new Position[2];
	}

	/**
	 * Check if map is valid
	 * 
	 * @param which line to start
	 * @param which line to finish
	 * @return the field
	 */
	public boolean checkMap(int startingline, int finishline) {

		for (int line = startingline; line < finishline; line++) {
			for (int column = 0; column < 8; column++) {
				if (field[line][column].checkField() == false) {
					
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Find movement between two maps (change from actualMap)
	 * 
	 * @param former map
	 * @return Move
	 */
	public Move findMovement(Map oldMap) {

		Move move = new Move();
		return move;
	}

	/**
	 * Generate new map content
	 * @param which line to start
	 * @param which line to finish
	 */
	public void generateMap(int startingline, int finishline) {

		for (int line = startingline; line < finishline; line++) {
			for (int column = 0; column < 8; column++) {
				field[line][column].setType(0);
			}
		}
				
		return;
	}
	
	/**
	 * showMap in CLI
	 * 
	 * @param avatar for which to be shown
	 */
	public void showMap(int id) {

		for (int line = 0; line < 8; line++) {
			for (int column = 0; column < 8; column++) {
				field[line][column].getType();
			}
		}
				
		return;
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
	 * @param number
	 *            of avatar
	 * @return the avatarPosition
	 */
	public Position getAvatarPosition(int id) {
		return avatarPosition[id];
	}

	/**
	 * @param number
	 *            of avatar
	 * @param avatarPosition
	 *            the avatarPosition to set
	 */
	public void setAvatarPosition(Position avatarPosition, int id) {
		this.avatarPosition[id] = avatarPosition;
	}

	/**
	 * @param number
	 *            of castle
	 * @return the castlePosition
	 */
	public Position getCastlePosition(int id) {
		return castlePosition[id];
	}

	/**
	 * @param id
	 *            of the castle
	 * @param castlePosition
	 *            the castlePosition to set
	 */
	public void setCastlePosition(Position castlePosition, int id) {
		this.castlePosition[id] = castlePosition;
	}

	/**
	 * @param id
	 *            of the treasure
	 * @return the treasurePosition
	 */
	public Position getTreasurePosition(int id) {
		return treasurePosition[id];
	}

	/**
	 * @param id
	 *            of the treasure
	 * @param treasurePosition
	 *            the treasurePosition to set
	 */
	public void setTreasurePosition(Position treasurePosition, int id) {
		this.treasurePosition[id] = treasurePosition;
	}
}
