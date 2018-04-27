package communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * do all of the communication for server and client principle idea:
 * Communication to other objects always get full xmlData-object and takes
 * information from there whatever is necessary
 * 
 */

public class RestAPIClient {

	public RestAPIClient() {
	}

	/**
	 * do all of the communication for server and client principle idea:
	 * Communication to other objects always get full xmlData-object and takes
	 * information from there whatever is necessary
	 * 
	 * RestAPIClient knows content from requesttype
	 * 
	 * @param serverUrl
	 *            - the URL of the server (always the same)
	 * @param path
	 *            - path behind the server URL
	 * @param type
	 *            - request Type
	 * @param xmlData
	 *            - information to be sent
	 * 
	 * @return xmlData - information that came back from server
	 * 
	 */

	public Object SendRequest(String serverUrl, String path, RequestType type, Object xmlData) {

		final Logger log = LoggerFactory.getLogger(RestAPIClient.class);

		RestTemplate restTemplate = new RestTemplate();
		JAXBContext jaxbContext;
		Unmarshaller unMarshaller;
		Marshaller marshaller;
		StringReader reader;
		StringWriter writer = new StringWriter();

		try {

			switch (type) {
			case NewGame: {
				String responseString;
				responseString = restTemplate.getForObject(serverUrl + "/" + path, String.class);
				jaxbContext = JAXBContext.newInstance(GameIdentifier.class);
				unMarshaller = jaxbContext.createUnmarshaller();
				/* Get data from XML-String */
				reader = new StringReader(responseString);
				return ((GameIdentifier) unMarshaller.unmarshal(reader));
			}
			case State: {
				String responseString;
				responseString = restTemplate.getForObject(serverUrl + "/" + path, String.class);
				jaxbContext = JAXBContext.newInstance(FortStatevalues.class,
						GameState.class,
						Map.class,
						MapNode.class,
						MapNodes.class,
						ObjectFactory.class,
						Player.class,
						PlayerGameStatevalues.class,
						PlayerStatevalues.class,
						Players.class,
						ResponseEnvelope.class,
						Statevalues.class,
						TerrainStatevalues.class,
						TresureStatevalues.class);
				unMarshaller = jaxbContext.createUnmarshaller();
				/* Get data from XML-String */
				reader = new StringReader(responseString);
				return ((ResponseEnvelope) unMarshaller.unmarshal(reader));
			}
			case Register: {
				jaxbContext = JAXBContext.newInstance(PlayerRegistration.class);
				marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				marshaller.marshal((PlayerRegistration) xmlData, writer);
				String responseString;
				responseString = restTemplate.postForObject(serverUrl + "/" + path, writer.toString(), String.class,
						writer);
				/* Get data from XML-String */
				unMarshaller = jaxbContext.createUnmarshaller();
				reader = new StringReader(responseString);
				return ((ResponseEnvelope) unMarshaller.unmarshal(reader));
			}
			case HalfMap: {
				jaxbContext = JAXBContext.newInstance(HalfMap.class);
				marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				marshaller.marshal((HalfMap) xmlData, writer);
				String responseString;
				responseString = restTemplate.postForObject(serverUrl + "/" + path, writer.toString(), String.class,
						writer);
				/* Get data from XML-String */
				unMarshaller = jaxbContext.createUnmarshaller();
				reader = new StringReader(responseString);
				return ((ResponseEnvelope) unMarshaller.unmarshal(reader));
			}
			case Move: {
				jaxbContext = JAXBContext.newInstance(AvatarMove.class);
				marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				marshaller.marshal((AvatarMove) xmlData, writer);
				String responseString;
				responseString = restTemplate.postForObject(serverUrl + "/" + path, writer.toString(), String.class,
						writer);
				/* Get data from XML-String */
				unMarshaller = jaxbContext.createUnmarshaller();
				reader = new StringReader(responseString);
				return ((ResponseEnvelope) unMarshaller.unmarshal(reader));
			}
			default: {
				return null;
			}
			}
		} catch (

		JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}