//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 09:34:52 PM CEST 
//


package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für gameState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="gameState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}players"/>
 *         &lt;element ref="{}map" minOccurs="0"/>
 *         &lt;element ref="{}gameStateId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlType(name = "gameState", propOrder = {
    "players",
    "gameStateId",
    "map"
})

@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ Players.class, Player.class, PlayerGameStatevalues.class, Map.class, MapNode.class, MapNodes.class})

public class GameState {

    @XmlElement(name="players", required = true)
    private final Players players;
    @XmlElement(name="map", required = false)
    private final Map map;
    @XmlElement(name="gameStateId", required = true)
    private final String gameStateId;

    public GameState () {
    	this.players = null;
    	this.map = null;
    	this.gameStateId = null;
    }
    
    public GameState(Players players, Map map, String gameStateId) {
    	this.players = players;
    	this.map = map;
    	this.gameStateId = gameStateId;
    }
    
    /**
     * Ruft den Wert der players-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Players }
     *     
     */
    public Players getPlayers() {
        return players;
    }

    /**
     * Ruft den Wert der map-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getMap() {
        return map;
    }

    /**
     * Ruft den Wert der gameStateId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGameStateId() {
        return gameStateId;
    }
}
