package dataobjects;

import messages.PlayerIdentifier;

public class PlayerID extends UniqueID{

	public PlayerID(PlayerIdentifier playerIdentifier)
	{
		super(playerIdentifier.getPlayerID());
	}
}