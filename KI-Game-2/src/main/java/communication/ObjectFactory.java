//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 09:34:52 PM CEST 
//


package communication;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the communication package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StudentID_QNAME = new QName("", "studentID");
    private final static QName _LastName_QNAME = new QName("", "lastName");
    private final static QName _FortState_QNAME = new QName("", "fortState");
    private final static QName _FirstName_QNAME = new QName("", "firstName");
    private final static QName _CollectedTreasure_QNAME = new QName("", "collectedTreasure");
    private final static QName _X_QNAME = new QName("", "X");
    private final static QName _Y_QNAME = new QName("", "Y");
    private final static QName _TresureState_QNAME = new QName("", "tresureState");
    private final static QName _UniquePlayerID_QNAME = new QName("", "uniquePlayerID");
    private final static QName _PlayerPositionState_QNAME = new QName("", "playerPositionState");
    private final static QName _GameStateId_QNAME = new QName("", "gameStateId");
    private final static QName _Terrain_QNAME = new QName("", "terrain");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: communication
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MapNode }
     * 
     */
    public MapNode createMapNode() {
        return new MapNode();
    }

    /**
     * Create an instance of {@link Players }
     * 
     */
    public Players createPlayers() {
        return new Players();
    }

    /**
     * Create an instance of {@link Player }
     * 
     */
    public Player createPlayer() {
        return new Player();
    }

    /**
     * Create an instance of {@link MapNodes }
     * 
     */
    public MapNodes createMapNodes() {
        return new MapNodes();
    }

    /**
     * Create an instance of {@link ResponseEnvelope }
     * 
     */
    public ResponseEnvelope createResponseEnvelope() {
        return new ResponseEnvelope();
    }

    /**
     * Create an instance of {@link Map }
     * 
     */
    public Map createMap() {
        return new Map();
    }

    /**
     * Create an instance of {@link GameState }
     * 
     */
    public GameState createGameState() {
        return new GameState();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "studentID")
    public JAXBElement<String> createStudentID(String value) {
        return new JAXBElement<String>(_StudentID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "lastName")
    public JAXBElement<String> createLastName(String value) {
        return new JAXBElement<String>(_LastName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FortStatevalues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fortState")
    public JAXBElement<FortStatevalues> createFortState(FortStatevalues value) {
        return new JAXBElement<FortStatevalues>(_FortState_QNAME, FortStatevalues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "firstName")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "collectedTreasure")
    public JAXBElement<Boolean> createCollectedTreasure(Boolean value) {
        return new JAXBElement<Boolean>(_CollectedTreasure_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "X")
    public JAXBElement<Integer> createX(Integer value) {
        return new JAXBElement<Integer>(_X_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Y")
    public JAXBElement<Integer> createY(Integer value) {
        return new JAXBElement<Integer>(_Y_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TresureStatevalues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tresureState")
    public JAXBElement<TresureStatevalues> createTresureState(TresureStatevalues value) {
        return new JAXBElement<TresureStatevalues>(_TresureState_QNAME, TresureStatevalues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uniquePlayerID")
    public JAXBElement<String> createUniquePlayerID(String value) {
        return new JAXBElement<String>(_UniquePlayerID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlayerStatevalues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "playerPositionState")
    public JAXBElement<PlayerStatevalues> createPlayerPositionState(PlayerStatevalues value) {
        return new JAXBElement<PlayerStatevalues>(_PlayerPositionState_QNAME, PlayerStatevalues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "gameStateId")
    public JAXBElement<String> createGameStateId(String value) {
        return new JAXBElement<String>(_GameStateId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TerrainStatevalues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "terrain")
    public JAXBElement<TerrainStatevalues> createTerrain(TerrainStatevalues value) {
        return new JAXBElement<TerrainStatevalues>(_Terrain_QNAME, TerrainStatevalues.class, null, value);
    }

}
