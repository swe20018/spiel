package dataobjects;

import messages.GameIdentifier;

public class GameID extends UniqueID{

	public GameID(GameIdentifier gameID)
	{
		super(gameID.getUniqueGameID());
	}
	public GameID(String gameID)
	{
		super(gameID);
	}
}
