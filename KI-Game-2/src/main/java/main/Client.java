package main;

import java.net.URL;
import dataobjects.GameID;
import dataobjects.PlayerID;
import dataobjects.PlayerInformation;

import map.*;
import movement.*;
import messages.*;
import communication.*;

/**
 * Client / KI component
 * 
 * will try to win!!!
 * 
 */

public class Client {

	/**
	 * showUsage
	 */
	static void showUsage() {
		System.out.println("Usage: <optional ServerUrl>");
	}

	public static void main(String[] args) throws Exception {

		PlayerGameStatevalues playerState = PlayerGameStatevalues.SHOULD_WAIT; /* State of the actual player */
		RestAPIClient client;
		String serverString = "http://swe.wst.univie.ac.at:18235/";

		boolean running = true;

		switch (args.length) {
		case 0: /* just start with default values */
			break;
		case 1: /* got optional ServerUrl */
			serverString = args[0];
			break;
		default: 
			showUsage();
			System.exit(0);
		}
		client = new RestAPIClient(serverString);
		
		/* Get Game-ID - Register */

		GameID gameID = client.createNewGame();

		System.out.println("GameID = " + gameID.getId());
		
		/* Get Player-ID - Register */
		
		PlayerID playerID = client.registerNewPlayer();

		System.out.println("GameID = " + gameID.getId() + " PlayerID = " + playerID.getId());
		System.exit(0);

		/* Wait for other Player - State */

		while (playerState == PlayerGameStatevalues.SHOULD_WAIT) {

			/* Wait 0,4 s */
			Thread.sleep(400);
		}
		/* Generate half map and send - HalfMap */

		/* start playing */

		while (running) {
			/* Wait for allowance to move - State */

			/* move - Move */
			/* Wait 0,4 s */
			Thread.sleep(400);
		}
	}
}
