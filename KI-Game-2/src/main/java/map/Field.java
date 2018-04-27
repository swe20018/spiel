package map;

public class Field {

	boolean hasAvatar[];
	boolean hasCastle[];
	boolean hasTreasure[];
	boolean hasMountainStepUp[];
	boolean hasMountainStepDown[];
	boolean hasBeenVisited[];
	int type;	/* meadow, water, mountain */

	public Field () {
		initField();
	}
	
	/**
	 * 
	 * @param type meadow, water, mountain
	 */
	public Field (int type) {
		
		initField();
		this.type = type;
	}
	
	private void initField() {
		
		hasAvatar = new boolean[2];
		hasCastle = new boolean[2];
		hasTreasure = new boolean[2];
		hasMountainStepUp = new boolean[2];
		hasMountainStepDown = new boolean[2];
		hasBeenVisited = new boolean[2];
		type = 0;
		
		for (int id = 0 ; id < 2 ; id++) {
			 hasAvatar[id] = false;
			 hasCastle[id] = false;
			 hasTreasure[id] = false;
			 hasMountainStepUp[id] = false;
			 hasMountainStepDown[id] = false;
			 hasBeenVisited[id] = false;
		}
	}
	/**
	 * 
	 * @param position of the field
	 * @return true if field is okay
	 */
	
	public boolean checkField(Position position) {
		return true;
	}
	/**
	 * 
	 * @return true if field is okay
	 */
	
	public boolean checkField() {
		return true;
	}

	/**
	 * check, if treasure is at field
	 *  
	 * @param position of the field
	 * @return true if field is okay
	 */
	boolean isTreasureFound() {
		return false;
	}
	/**
	 * check, if treasure is at field
	 *  
	 * @param position of the field
	 * @return true if field is okay
	 */
	boolean isCastleFound(int id) {
		
		return false;
	}

	/**
	 * @author param id of avatar
	 * @return if avatar is there
	 */
	public boolean hasAvatar(int id) {
		return hasAvatar[id];
	}

	/**
	 * @param id of avatar set to field
	 */
	public void setAvatar(int id) {
		this.hasAvatar[id] = true;
	}

	/**
	 * @param if of avatar
	 * @return the hasCastle
	 */
	public boolean HasCastle(int id) {
		return hasCastle[id];
	}

	/**
	 * @param id of the avatar 
	 * 
	 */
	public void setCastle(int id) {
		this.hasCastle[id] = true;
	}

	/**
	 * @param id of the avatar 
	 * @return the hasTreasure
	 */
	public boolean hasTreasure(int id) {
		return hasTreasure[id];
	}

	/**
	 * @param id of the avatar 
	 */
	public void setTreasure(int id) {
		this.hasTreasure[id] = true;
	}

	/**
	 * @param id of the avatar 
	 * @return the hasMountainStepUp
	 */
	public boolean hasMountainStepUp(int id) {
		return hasMountainStepUp[id];
	}

	/**
	 * @param id of the avatar 
	 */
	public void setMountainStepUp(int id) {
		this.hasMountainStepUp[id] = true;
	}

	/**
	 * @param id of the avatar 
	 * @return the hasMountainStepDown
	 */
	public boolean hasMountainStepDown(int id) {
		return hasMountainStepDown[id];
	}

	/**
	 * @param id of the avatar 
	 */
	public void setMountainStepDown(int id) {
		this.hasMountainStepDown[id] = true;
	}

	/**
	 * @param id of the avatar 
	 * @return the hasMountainStepDown
	 */
	public boolean hasBeenVisited(int id) {
		return hasBeenVisited[id];
	}

	/**
	 * @param id of the avatar 
	 */
	public void setBeenVisited(int id) {
		this.hasBeenVisited[id] = true;
	}
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}	
}
