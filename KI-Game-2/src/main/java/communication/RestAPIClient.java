package communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import dataobjects.GameID;
import dataobjects.PlayerID;
import dataobjects.PlayerInformation;
import messages.*;
import map.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

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

	public PlayerID registerNewPlayer() throws Exception {

		RegisterPlayer payload = new RegisterPlayer(PlayerInformation.getMatnr(), PlayerInformation.getFirstname(),
				PlayerInformation.getLastname());

		URL registerNewPlayerUrl = new URL(serverUrl, "game/" + uniqueGameID.getId() + "/register");
		RestTemplate restTemplate = new RestTemplate();

		ResponseEnvelope<PlayerIdentifier> playerIdMessage = restTemplate.postForObject(registerNewPlayerUrl.toURI(),
				payload, ResponseEnvelope.class);

		uniquePlayerID = new PlayerID(playerIdMessage.getData());

		return uniquePlayerID;
	}

	/**
	 * Send own half Map to the server
	 * 
	 * @return if there is an error got from Server
	 */

	public boolean sendHalfMap(LocalMap map) throws Exception {

		HalfMap.NewMapNodes value = new HalfMap.NewMapNodes();

		/* pay attention: line = Y, column = X */

		for (int line = 0; line < 3; line++) {
			for (int column = 0; column < 8; column++) {
				HalfMap.NewMapNodes.NewMapNode element = new HalfMap.NewMapNodes.NewMapNode();
				element.setX(column);
				element.setY(line);
				element.setTerrain(map.getField(line, column).getType());
				if (map.getField(line, column).getFortState() == FortStatevalues.MY_FORT_PRESENT)
					element.setFortPresent(true);
				else
					element.setFortPresent(true);
				value.getNewMapNode().add(element);
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

	public PlayerGameStatevalues checkPlayState(LocalMap map) throws Exception {

		URL checkPlayStateUrl = new URL(serverUrl, "game/" + uniqueGameID.getId() + "/state/" + uniquePlayerID.getId());
		RestTemplate restTemplate = new RestTemplate();

		ResponseEnvelope<GameState> gameStateMessage = restTemplate.getForObject(checkPlayStateUrl.toURI(),
				ResponseEnvelope.class);

		if (gameStateMessage.getState() == ResponseState.OK) {

			System.out.println(gameStateMessage.getData());
			
			/******************** just for test *****************/
			if (null == null)
				return PlayerGameStatevalues.SHOULD_ACT_NEXT;
			
			/* Transfer Map from Server to local Map */

			/* pay attention: line = Y, column = X */

			for (int nodeNumber = 0; nodeNumber < 64; nodeNumber++) {

				MapNode node = gameStateMessage.getData().getMap().getMapNodes().getMapNode().get(nodeNumber);

				int line = node.getY();
				int column = node.getX();
				Field field = map.getField(line, column);
				field.setType(node.getTerrain());
				field.setFortState(node.getFortState());
				field.setTreasureState(node.getTresureState());
				field.setPlayerState(node.getPlayerPositionState());
				
				/* Save some interesting positions */
				switch (field.getPlayerState()) {
				case BOTH_PLAYER_POSITION:
					map.setAvatarPosition(new Position(line, column));
				case ENEMY_PLAYER_POSITION:
					if (null == map.getFirstEnemyPosition()) {
						/*
						 * never got Enemyposition, this is the first time - and only 10 steps away
						 * castle
						 */
						/* this will help to find enemy´s castle quicker */

						map.setFirstEnemyPosition(new Position(line, column));
					}
				case MY_POSITION:
					map.setAvatarPosition(new Position(line, column));
					break;
				case NO_PLAYER_PRESENT:
					break;
				}
			}
			
			/* Get Info from Players */

			Players players = gameStateMessage.getData().getPlayers();
			Player player1 = players.getPlayer().get(0);
			System.out.println(player1.getLastName());
			Player player2 = players.getPlayer().get(1);
			System.out.println(player2.getLastName());
			if (player1.getStudentID() == PlayerInformation.getMatnr()) {
				/* it´s myself */
				if ((false == hasCollectedTreasure) &&
						(player1.isCollectedTreasure())) {
					/* and I found the treasure */
					System.out.println("*****Treasure found *****");
					map.clearVisitState(); /* start over walking */
					hasCollectedTreasure = true;
				}
				return player1.getState();
			} else {
				return player2.getState();
			}
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
}