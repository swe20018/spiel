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

	public RestAPIClient(String serverUrl) throws Exception {
		this.serverUrl = new URL(serverUrl);
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

	public boolean sendHalfMap(String uniquePlayerID, LocalMap map) throws Exception {

		HalfMap.NewMapNodes value = new HalfMap.NewMapNodes();

		/* pay attention: line = Y, column = X */
		
		for (int line = 0; line < 3; line++) {
			for (int column = 0; column < 8; column++) {
				HalfMap.NewMapNodes.NewMapNode element = new HalfMap.NewMapNodes.NewMapNode();
				element.setX(column);
				element.setY(line);
				element.setTerrain(map.getField(line, column).getType());
				element.setFortPresent(map.getField(line, column).HasCastle());
				value.getNewMapNode().add(element);
			}
		}
		
		HalfMap payload = new HalfMap();
		payload.setUniquePlayerID(uniquePlayerID);
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

	/* check play state */

	public void checkPlayState() {
		return;
	}
}