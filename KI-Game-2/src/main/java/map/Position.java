package map;

/**
 * 
 * class for storing specific positions
 *
 */

public class Position {

	private int line;
	private int column;
	/**
	 * constructor without parameters
	 */
	public Position() {
		line = 0;
		column = 0;
	}
	/**
	 * constructor without parameters
	 * @param line - line of the position
	 * @param column - column of the position
	 */
	public Position(int line, int column) {
		this.line = line;
		this.column = column;
	}
	/**
	 * @return the line
	 */
	public int getLine() {
		return line;
	}
	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}
	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}	
}