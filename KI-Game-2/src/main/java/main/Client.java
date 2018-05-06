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
		GameID gameID = null;;

		boolean running = true;

		switch (args.length) {
		case 0: /* just start with default values */
			break;
		case 1: /* could be optional ServerUrl or optional game-ID*/
			if (args[0].startsWith("http"))
				serverString = args[0];
			else
				gameID = new GameID(args[0]);
			break;
		default:
			showUsage();
			System.exit(0);
		}
		
		client = new RestAPIClient(serverString);

		if (null == gameID) {
			/* Get Game-ID - Register */

			gameID = client.createNewGame();
		}

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
		
		client.sendHalfMap(map);
		Movement move = new Movement();

		/* Wait for other Player - State */

		for (;;) {
		
			switch (client.checkPlayState(map)) {
			case SHOULD_WAIT:
				Thread.sleep(400);
				continue;
			case SHOULD_ACT_NEXT:
				/********************* client.sendMovement(move.doMove(map, client.hasCollectedTreasure())); ************/
				move.doMove(map, client.hasCollectedTreasure());
				map.showLocalMap();
				Thread.sleep(2000);
				continue;
				/******************** break; **************/
			case LOST:
				System.out.println(PlayerInformation.getFirstname() + " won the game " + gameID.getId());
				System.exit(0);
				break;
			case WON:
				System.out.println("Dumb computer lost the game " + gameID.getId());
				System.exit(0);
				break;
			}
		}
	}
}
