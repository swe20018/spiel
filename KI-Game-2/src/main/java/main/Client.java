package main;

import java.net.URL;

import org.junit.experimental.theories.Theories;

import dataobjects.GameID;
import dataobjects.PlayerID;
import dataobjects.PlayerInformation;

import map.*;
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

		/* Get Player-ID - Register */

		PlayerID playerID = client.registerNewPlayer();

		System.out.println("GameID = " + gameID.getId() + " PlayerID = " + playerID.getId());

		/* Generate Map and regenerate, as long as it has errors */

		LocalMap map = new LocalMap();

		do {

			map.generateHalfMap();
		} while (false == map.checkLocalMap());

		map.showLocalMap();

		/* ignore response to sendhalfmap, will get ERROR in every situation */
		
		client.sendHalfMap(playerID.getId(), map);

		/* Wait for other Player - State */

		while (true == client.checkPlayState(map)) {

			System.exit(0);
			if (playerState == PlayerGameStatevalues.SHOULD_WAIT) {

				/* Wait 0,4 s */
				Thread.sleep(400);
			}
		}

		
		/* start playing */

		while (running) {
			/* Wait for allowance to move - State */

			/* move - Move */
			/* Wait 0,4 s */
			Thread.sleep(400);
		}
	}
}
