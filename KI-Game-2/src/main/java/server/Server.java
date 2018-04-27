package server;

import map.*;
import communication.*;
import movement.*;

/**
 * Server component
 * 
 * Will handle all requests from clients or gui Will check if maps and moves are
 * okay Will response with actual map and additional information like positions
 * of avatars, treasures and castles Map response depends on visibility rules
 * for clients
 * 
 */

public class Server {

	public static void main(String[] args) {

		boolean running = true; /* possibility to stop by request */
		long avatar1 = 0;
		long avatar2 = 0;
		Map map = new Map();
		XMLData xmldata;
		RestAPI restapi = new RestAPI();

		while (running) {

			xmldata = restapi.waitForRequest();

			/* extract request and id from DOM-object */

			long id = xmldata.getId();

			switch (xmldata.getRequest()) {
			case "IAMHERE": {
				/* client or gui tells, it is here */
				/* client tells half of map */
				map = xmldata.getMap();
				if (map.checkMap(0, 4) == false) {
					xmldata.setResponse("DISQUALIFIED");
					xmldata.setWaitingtime(3);
				} else {
					xmldata.setResponse("WAIT");
					xmldata.setWaitingtime(3);
				}
				if (avatar1 == 0)
					avatar1 = xmldata.getId();
				else
					avatar2 = xmldata.getId();
			}
			case "IWANTTOMOVE": {
				xmldata.setResponse("WAIT");
				xmldata.setWaitingtime(3);
			}
			case "IMOVE": {
				/* client or gui tells, it is here */
				/* client tells half of map */
				Map oldMap = map;
				map = xmldata.getMap();
				Move move = map.findMovement(oldMap);
				if (move.isMoveValid(map, move) == false) {
					xmldata.setResponse("DISQUALIFIED");
					xmldata.setWaitingtime(3);
				} else {
					xmldata.setResponse("WAIT");
					xmldata.setWaitingtime(3);
				}
				xmldata.setResponse("DISQUALIFIED");
				xmldata.setWaitingtime(0);
			}
			case "GETMAP": {
				xmldata.setMap(map);
				xmldata.setResponse("WAIT");
				xmldata.setWaitingtime(2);
			}
			default: {
				/* do nothing, just log */
				xmldata.setResponse("DISQUALIFIED");
				xmldata.setWaitingtime(0);
			}
			}
			restapi.sendResponse(xmldata);
		}
	}
}
