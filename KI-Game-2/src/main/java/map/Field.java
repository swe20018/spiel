package map;

import communication.*;
import messages.*;

public class Field {

	private PlayerStatevalues	playerState;		/* own Avatar */
	private FortStatevalues fortState;
	private TresureStatevalues treasureState;
	boolean hasEnemy;		/* other Avatars first occurence, maybe helps to find other castle*/
	boolean hasBeenVisited;
	
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
		
		playerState = PlayerStatevalues.NO_PLAYER_PRESENT;
		fortState = FortStatevalues.NO_OR_UNKNOWN_FORT_STATE;
		treasureState = TresureStatevalues.NO_OR_UNKNOWN_TRESURE_STATE;
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
		
		switch (playerState) {
		
		case NO_PLAYER_PRESENT:
			info += "  ";
			break;
		case BOTH_PLAYER_POSITION:
			info += "ae";
			break;
		case ENEMY_PLAYER_POSITION:
			info += " e";
			break;
		case MY_POSITION:
			info += "a ";
		}

		switch (fortState) {
		case ENEMY_FORT_PRESENT:
			info += "E";
			break;
		case MY_FORT_PRESENT:
			info += "A";
			break;
		case NO_OR_UNKNOWN_FORT_STATE:
			info += " ";
			break;
		}
		
		switch (treasureState) {
		case MY_TRESURE_IS_PLACED_HERE:
			info += "*";
			break;
		case NO_OR_UNKNOWN_TRESURE_STATE:
			info += " ";
			break;
		}
	
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
	/**
	 * @param type the type to set
	 */
	public void setType(TerrainStatevalues type) {
		
		switch (type) {
		
		case GRASS:
			this.type = Terraintype.GRASS;
			break;
		case WATER:
			this.type = Terraintype.WATER;
			break;
		case MOUNTAIN:
			this.type = Terraintype.MOUNTAIN;
			break;
		}
	}
	/**
	 * @return the playerState
	 */
	public PlayerStatevalues getPlayerState() {
		return playerState;
	}

	/**
	 * @param playerState the playerState to set
	 */
	public void setPlayerState(PlayerStatevalues playerState) {
		this.playerState = playerState;
	}

	/**
	 * @return the fortState
	 */
	public FortStatevalues getFortState() {
		return fortState;
	}

	/**
	 * @param fortState the fortState to set
	 */
	public void setFortState(FortStatevalues fortState) {
		this.fortState = fortState;
	}

	/**
	 * @return the treasureState
	 */
	public TresureStatevalues getTreasureState() {
		return treasureState;
	}

	/**
	 * @param treasureState the treasureState to set
	 */
	public void setTreasureState(TresureStatevalues treasureState) {
		this.treasureState = treasureState;
	}
}
