package movement;

import map.*;
/**
 * 
 * generate movements
 *
 */

public class Move {

	Position fromPosition;
	Position toPosition;
	
	public Move() {
		fromPosition = new Position();
		toPosition = new Position();
	}
	
	/**
	 * check, if a specific move is valid
	 * 
	 * @param map
	 * @param move
	 * @return
	 */
	public boolean isMoveValid(Map map, Move move) {
	
		return false;
	}
	
	/**
	 * calculate different move-possibilities
	 * 
	 * @param map
	 * @param old Position
	 * @param new Position
	 * @return
	 */
	public int calculateMove(Map map, Position oldPosition, Position newPosition) {
	
		int value = 0;
		
		return value;
	}
	
	/**
	 * make a really good move
	 * 
	 * @param map
	 * @param old Position
	 * @return
	 */
	public Position makeMove(Map map, Position oldPosition) {
	
		Position newPosition = new Position();
		return newPosition;
	}

	/**
	 * @return the fromPosition
	 */
	public Position getFromPosition() {
		return fromPosition;
	}

	/**
	 * @param fromPosition the fromPosition to set
	 */
	public void setFromPosition(Position fromPosition) {
		this.fromPosition = fromPosition;
	}

	/**
	 * @return the toPosition
	 */
	public Position getToPosition() {
		return toPosition;
	}

	/**
	 * @param toPosition the toPosition to set
	 */
	public void setToPosition(Position toPosition) {
		this.toPosition = toPosition;
	}
}
