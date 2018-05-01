package map;

import messages.Terraintype;

public class Field {

	boolean hasAvatar;		/* own Avatar */
	boolean hasCastle;
	boolean hasTreasure;
	boolean hasBeenVisited;
	boolean hasEnemy;		/* other Avatar, maybe helps to find other castle*/
	
	private Terraintype type;

	public Field () {
		initField();
	}
	
	/**
	 * 
	 * @param type grass, water, mountain
	 */
	public Field (Terraintype type) {
		
		initField();
		this.type = type;
	}
	
	private void initField() {
		
		hasAvatar = false;
		hasCastle = false;
		hasTreasure = false;
		hasBeenVisited = false;
		hasEnemy = false;
		type = Terraintype.EMPTY;
	}
	
	/* show content of the field */
	
	public String showField () {
		
		String info = "";
		
		switch (type) {
		
		case GRASS:
			info += "G";
			break;
		case WATER:
			info += "W";
			break;
		case MOUNTAIN:
			info += "M";
			break;
		case EMPTY:
			info += " ";
			break;
		}
		
		if (hasAvatar)
			info += "A";
		else
			info += " ";
		
		if (hasCastle)
			info += "C";
		else
			info += " ";
		
		if (hasTreasure)
			info += "*";
		else
			info += " ";
		
		if (hasEnemy)
			info += "E";
		else
			info += " ";
		
		return info;
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
	 * @return if avatar is there
	 */
	public boolean hasAvatar() {
		return hasAvatar;
	}

	/**
	 * @param id of avatar set to field
	 */
	public void setAvatar() {
		this.hasAvatar = true;
	}

	/**
	 * @return the hasCastle
	 */
	public boolean HasCastle() {
		return hasCastle;
	}

	/**
	 * 
	 */
	public void setCastle() {
		this.hasCastle = true;
	}

	/**
	 * @return the hasTreasure
	 */
	public boolean hasTreasure() {
		return hasTreasure;
	}

	/**
	 * @param id of the avatar 
	 */
	public void setTreasure() {
		this.hasTreasure = true;
	}

	/**
	 * @param id of the avatar 
	 * @return the hasMountainStepDown
	 */
	public boolean hasBeenVisited() {
		return hasBeenVisited;
	}

	/**
	 */
	public void setBeenVisited() {
		this.hasBeenVisited = true;
	}
	
	/**
	 * @return the hasMountainStepDown
	 */
	public boolean hasEnemy() {
		return hasEnemy;
	}

	/**
	 * @param id of the avatar 
	 */
	public void setEnemy() {
		this.hasEnemy = true;
	}
	
	/**
	 * @return the type
	 */
	public Terraintype getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Terraintype type) {
		this.type = type;
	}	
}
