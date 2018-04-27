package client;

import map.*;
import communication.*;
import movement.*;

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
		System.out.println("Usage: <Modus> <BasisUrlServer> <SpielID>");
		System.out.println("        Modus VI - just view the map");
		System.out.println("        Modus NG - New Game, get SpielID");
		System.out.println("        Modus TR - Play");
	}

	public static void main(String[] args) throws InterruptedException {

		String gameID = "empty"; /* Unique ID of a game */
		String playerID = "empty"; /* Unique ID of a player */
		String serverUrl = "epmty"; /* URL of the server */
		PlayerGameStatevalues playerState = PlayerGameStatevalues.SHOULD_WAIT; /* State of the actual player */
		RestAPIClient client = new RestAPIClient();
		boolean running = true;

		switch (args.length) {
		case 0: /* show usage */
		case 1: /* show usage */
			showUsage();
			System.exit(0);
		case 2: /* New Game? */
			if (args[1].equals("NG")) {
				serverUrl = args[2];
				/* Start new game, ask Server for SpielID */
				GameIdentifier identifier = (GameIdentifier) client.SendRequest(serverUrl, "game/new",
						RequestType.NewGame, null);
				System.out.println("GameID = " + identifier.getUniqueGameID());
			} else {
				showUsage();
			}
			System.exit(0);
		case 3: /* New Game? */
			if (args[1].equals("TR")) {
				/* Play */
				serverUrl = args[2];
				gameID = args[3];
				System.out.println("GameID = " + gameID);
			} else if (args[1].equals("VI")) {
				/* Visualize what happens in 3d */
				System.out.println("not yet implemented");
			} else {
				showUsage();
			}
			System.exit(0);
		}

		/* Get Spieler-ID - Register */

		UniquePlayerIdentifier identifier = (UniquePlayerIdentifier) client.SendRequest(serverUrl,
				"game/" + gameID + "register", RequestType.Register, null);
		playerID = identifier.getUniquePlayerID();
		System.out.println("PlayerID = " + playerID);

		/* Wait for other Player - State */

		while (playerState == PlayerGameStatevalues.SHOULD_WAIT) {

			PlayerGameStatevalues stateValue = (PlayerGameStatevalues) client.SendRequest(serverUrl,
					"game/" + gameID + "/state/" + playerID, RequestType.State, null);
			playerState = stateValue;
			System.out.println("Statevalue = " + playerState);

			/* Wait 0,4 s */
			Thread.sleep(400);
		}
		/* Generate half map and send - HalfMap */

		/* start playing */

		while (running) {
			/* Wait for allowance to move - State */

			/* move - Move */
		}
	}
}
