package main;

import java.net.URL;

import org.junit.experimental.theories.Theories;

import dataobjects.GameID;
import dataobjects.PlayerID;
import dataobjects.PlayerInformation;
import org.apache.commons.cli.*;

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

	public static void main(String[] args) throws Exception {

		PlayerGameStatevalues playerState = PlayerGameStatevalues.SHOULD_WAIT; /* State of the actual player */
		RestAPIClient client;
		String serverString = null;
		GameID gameID = null;
		PlayerInformation playerInformation = new PlayerInformation();

		boolean running = true;

		/* parse command line options */

		Options options = new Options();

		Option serverStringOption = new Option("s", "serverString", true, "Path to the server");
		serverStringOption.setRequired(false);
		serverStringOption.setArgName("Server Path");
		options.addOption(serverStringOption);

		Option gameIdOption = new Option("g", "gameID", true, "ID of a game");
		gameIdOption.setRequired(false);
		gameIdOption.setArgName("Game-ID");
		options.addOption(gameIdOption);

		Option playerMatNrOption = new Option("m", "matNr", true, "Players Matrikel Number");
		playerMatNrOption.setRequired(false);
		playerMatNrOption.setArgName("MatNr");
		options.addOption(playerMatNrOption);
		Option playerFirstNameOption = new Option("f", "FirstName", true, "Players First Name");
		playerFirstNameOption.setRequired(false);
		playerFirstNameOption.setArgName("FirstName");
		options.addOption(playerFirstNameOption);
		Option playerLastNameOption = new Option("l", "LastName", true, "Players Last Name");
		playerLastNameOption.setRequired(false);
		playerLastNameOption.setArgName("LastName");
		options.addOption(playerLastNameOption);

		CommandLineParser commandLineParser = new DefaultParser();
		HelpFormatter helpFormatter = new HelpFormatter();
		CommandLine commandLine;

		try {
			commandLine = commandLineParser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp("KI-Game", options);

			System.exit(1);
			return;
		}
	
		serverString = commandLine.getOptionValue("s", "http://swe.wst.univie.ac.at:18235/");
		client = new RestAPIClient(serverString);

		if (commandLine.hasOption("g")) {
			gameID = new GameID(commandLine.getOptionValue("g"));
			client.setGameId(gameID);
		}
		else {
			/* Get Game-ID - Register */

			gameID = client.createNewGame();
		}
		
		System.out.println(gameID.getId());
			
		playerInformation.setMatnr(commandLine.getOptionValue("m", playerInformation.getMatnr()));
		playerInformation.setFirstName(commandLine.getOptionValue("f", playerInformation.getFirstName()));
		playerInformation.setLastName(commandLine.getOptionValue("l", playerInformation.getLastName()));

		/* Get Player-ID - Register */

		PlayerID playerID = client.registerNewPlayer(playerInformation);

		System.out.println("GameID = " + gameID.getId() + " PlayerID = " + playerID.getId());

		/* Generate Map and regenerate, as long as it has errors */

		LocalMap map = new LocalMap();

		do {

			map.generateHalfMap();
		} while (false == map.checkLocalMap());

		// map.showLocalMap();

		/* ignore response to sendhalfmap, will get ERROR in every situation */

		client.sendHalfMap(map);
		
		/* Initialise grid for movment */
		
		Movement move = new Movement();

		/* Wait for other Player - State */

		for (;;) {

			playerState = client.checkPlayState(map, playerInformation);
			System.out.println ("GameID = " + gameID.getId() + " PlayerID = " + playerID.getId() + " " + playerState);
			
			switch (playerState) {
			case SHOULD_WAIT:
				Thread.sleep(2000);
				continue;
			case SHOULD_ACT_NEXT:
				move.doMove(map, client.hasCollectedTreasure());
				client.sendMovement(move.doMove(map, client.hasCollectedTreasure()));
				//map.showLocalMap();
				Thread.sleep(2000);
				break;
			case WON:
				System.out.println(playerInformation.getFirstName() + " won the game " + gameID.getId());
				System.exit(0);
				break;
			case LOST:
				System.out.println("Dumb computer lost the game " + gameID.getId());
				System.exit(0);
				break;
			}
		}
	}
}
