package communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import dataobjects.GameID;
import dataobjects.PlayerID;
import dataobjects.PlayerInformation;
import messages.GameIdentifier;
import messages.PlayerGameStatevalues;
import messages.RegisterPlayer;
import messages.ResponseEnvelope;
import messages.ResponseState;
import messages.UniquePlayerIdentifier;
import messages.PlayerIdentifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
}