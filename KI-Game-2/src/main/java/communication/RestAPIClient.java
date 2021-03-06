package communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.client.RestTemplate;
import org.springframework.boot.logging.*;

import dataobjects.*;
import messages.*;
import map.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * do all of the communication for server and client principle idea:
 * Communication to other objects always get full xmlData-object and takes
 * information from there whatever is necessary
 * 
 */

public class RestAPIClient {

	private URL serverUrl;
	private GameID uniqueGameID;
	private PlayerID uniquePlayerID;
	private boolean hasCollectedTreasure;

	public RestAPIClient(String serverUrl) throws Exception {
		this.serverUrl = new URL(serverUrl);
		hasCollectedTreasure = false;

		
	}

	/**
	 * @return the hasCollectedTreasure
	 */
	public boolean hasCollectedTreasure() {
		return hasCollectedTreasure;
	}

	/**
	 * Start new Game, connect to server and ask for gameID
	 * 
	 * @return GameID got from Server
	 */
	public GameID createNewGame() throws Exception {

		URL newGameUrl = new URL(serverUrl, "game/new");
		RestTemplate restTemplate = new RestTemplate();
		GameIdentifier gameIdentifierMessage = restTemplate.getForObject(newGameUrl.toURI(), GameIdentifier.class);

		uniqueGameID = new GameID(gameIdentifierMessage);
		return uniqueGameID;
	}

	/**
	 * Register new Player to play
	 * 
	 * @return PlayerID got from Server
	 */

	public PlayerID registerNewPlayer(PlayerInformation playerInformation) throws Exception {

		RegisterPlayer payload = new RegisterPlayer(playerInformation.getMatnr(), playerInformation.getFirstName(),
				playerInformation.getLastName());

		URL registerNewPlayerUrl = new URL(serverUrl, "game/" + uniqueGameID.getId() + "/register");
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEnvelope<PlayerIdentifier> playerIdMessage = restTemplate.postForObject(registerNewPlayerUrl.toURI(),
				payload, ResponseEnvelope.class);

		if (playerIdMessage.getState() != ResponseState.OK) {
			/* not okay to register, forget it */
			System.exit(1);
		}
		
		uniquePlayerID = new PlayerID(playerIdMessage.getData());

		return uniquePlayerID;
	}

	/**
	 * Send own half Map to the server
	 * 
	 * @return if there is an error got from Server
	 */

	public boolean sendHalfMap(LocalMap map, int initLine) throws Exception {

		HalfMap.NewMapNodes value = new HalfMap.NewMapNodes();

		/* pay attention: line = Y, column = X */

		for (int line = 0; line < 4; line++) {
			for (int column = 0; column < 8; column++) {
				HalfMap.NewMapNodes.NewMapNode element = new HalfMap.NewMapNodes.NewMapNode();
				element.setX(column);
				element.setY(line);
				element.setTerrain(map.getField(line + initLine, column).getType());
				if (map.getField(line + initLine, column).getFortState() == FortStatevalues.MY_FORT_PRESENT)
					element.setFortPresent(true);
				else
					element.setFortPresent(false);
				value.getNewMapNode().add(element);
				/* System.out.println("X: "+ element.getX() + " Y:" + element.getY()); */
			}
		}

		HalfMap payload = new HalfMap();
		payload.setUniquePlayerID(uniquePlayerID.getId());
		payload.setNewMapNodes(value);

		URL sendHalfMapUrl = new URL(serverUrl, "game/" + uniqueGameID.getId() + "/halfmap");
		RestTemplate restTemplate = new RestTemplate();

		ResponseEnvelope<HalfMapAnswer> halfMapMessage = restTemplate.postForObject(sendHalfMapUrl.toURI(), payload,
				ResponseEnvelope.class);

		if (halfMapMessage.getState() == ResponseState.OK)
			return true;
		else {
			System.out.println(halfMapMessage.getExceptionMessage());
			System.out.println(halfMapMessage.getExceptionName());
			return false;
		}
	}

	/**
	 * get play state from server param playID and map Answer could include map
	 * information and player information
	 * 
	 * @return if there is an error got from Server
	 */

	public PlayerGameStatevalues checkPlayState(LocalMap map, PlayerInformation playerInformation) throws Exception {

		URL checkPlayStateUrl = new URL(serverUrl, "game/" + uniqueGameID.getId() + "/state/" + uniquePlayerID.getId());
		RestTemplate restTemplate = new RestTemplate();
		PlayerGameStatevalues myGameStateValue = PlayerGameStatevalues.SHOULD_WAIT;
		
		ResponseEnvelope<GameState> gameStateMessage = restTemplate.getForObject(checkPlayStateUrl.toURI(),
				ResponseEnvelope.class);
	
		if (gameStateMessage.getState() == ResponseState.OK) {

			/* Get Info from Players / at least myself */

			Players players = gameStateMessage.getData().getPlayers();
			Player player1 = players.getPlayer().get(0);

			if (players.getPlayer().size() == 2) {
				/* got Information about second player */
			
				Player player2 = players.getPlayer().get(1);
				
				if (player2.getStudentID().equals(playerInformation.getMatnr())) {
					/* it�s myself */
					if ((false == hasCollectedTreasure) &&
							(player2.isCollectedTreasure())) {
						/* and I found the treasure */
						System.out.println("*****Treasure found *****");
						map.clearVisitState(); /* start over walking */
						hasCollectedTreasure = true;
					}
					myGameStateValue = player2.getState();
				}
			}
			
			if (player1.getStudentID().equals(playerInformation.getMatnr())) {
				/* it�s myself */
				if ((false == hasCollectedTreasure) &&
						(player1.isCollectedTreasure())) {
					/* and I found the treasure */
					System.out.println("*****Treasure found *****");
					map.clearVisitState(); /* start over walking */
					hasCollectedTreasure = true;
				}
				myGameStateValue = player1.getState();
			}
			
			/* check, if map present */

			if (null == gameStateMessage.getData().getMap()) {
				/* did not get a map */
				return myGameStateValue;
			}
			
			/* Transfer Map from Server to local Map */

			/* pay attention: line = Y, column = X */

			for (int nodeNumber = 0; nodeNumber < gameStateMessage.getData().getMap().getMapNodes().getMapNode().size(); nodeNumber++) {
						
				MapNode node = gameStateMessage.getData().getMap().getMapNodes().getMapNode().get(nodeNumber);


				int line = node.getY();
				int column = node.getX();
				Field field = map.getField(line, column);
				field.setType(node.getTerrain());
				field.setFortState(node.getFortState());
				field.setTreasureState(node.getTresureState());
				field.setPlayerState(node.getPlayerPositionState());
				System.out.println("Y/line: " + line + " X/column " + column + " : " + field.showField());
				
				/* Save some interesting positions */
				switch (field.getPlayerState()) {
				case BOTH_PLAYER_POSITION:
					map.setAvatarPosition(new Position(line, column));
					map.getField(line, column).setBeenVisited();
				case ENEMY_PLAYER_POSITION:
					if (null == map.getFirstEnemyPosition()) {
						/*
						 * never got Enemyposition, this is the first time - and only 10 steps away
						 * castle
						 */
						/* this will help to find enemy�s castle quicker */

						map.setFirstEnemyPosition(new Position(line, column));
					}
					break;
				case MY_POSITION:
					map.setAvatarPosition(new Position(line, column));
					map.getField(line, column).setBeenVisited();
					break;
				case NO_PLAYER_PRESENT:
					break;
				}
			}
			map.showLocalMap();
			return myGameStateValue;
		} else {
			System.out.println(gameStateMessage.getExceptionMessage());
			System.out.println(gameStateMessage.getExceptionName());
			return PlayerGameStatevalues.LOST;
		}
	}

	/**
	 * send the planned move to the server Answer is only a response envelope
	 * 
	 * @return okay or error - and this may be ignored
	 */

	public boolean sendMovement(MoveValues move) throws Exception {

		System.out.println(move);
		
		AvatarMove payload = new AvatarMove();
		payload.setUniquePlayerID(uniquePlayerID.getId());
		payload.setMove(move);

		URL sendMoveUrl = new URL(serverUrl, "game/" + uniqueGameID.getId() + "/move");
		RestTemplate restTemplate = new RestTemplate();

		ResponseEnvelope<HalfMapAnswer> moveMessage = restTemplate.postForObject(sendMoveUrl.toURI(), payload,
				ResponseEnvelope.class);

		if (moveMessage.getState() == ResponseState.OK)
			return true;
		else {
			System.out.println(moveMessage.getExceptionMessage());
			System.out.println(moveMessage.getExceptionName());
			return false;
		}
	}
	
	public void setGameId (GameID uniqueGameID) {
		this.uniqueGameID = uniqueGameID;
	}
}