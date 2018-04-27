package communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * do all of the communication for server and client
 * 
 */

public class RestAPIServer {

	public RestAPIServer() {
	};

	/**
	 * Send Request to the Server
	 * 
	 * @param ServerUrl
	 * @param path
	 * @param type
	 *            GET or POST
	 * @param XMLData
	 *            or null
	 * @return XMLData or null
	 * @see 
	 */

	public String SendRequest(String serverUrl, String path, String type, Object xmlData) {

		
	    final Logger log = LoggerFactory.getLogger(RestAPIClient.class);
	    		   
		RestTemplate restTemplate = new RestTemplate();
		String s;

		if (type.equals("GET")) {
			s = restTemplate.getForObject(serverUrl + path, String.class);
		} else if (type.equals("POST")) {
			s = restTemplate.postForObject(serverUrl + path, xmlData, String.class);
		} else {
			return null;
		}
		log.info(s);

		/* do Rest-API */

		return s;
	}
}