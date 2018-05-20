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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import communication.FortStatevalues;
import communication.PlayerStatevalues;
import communication.TerrainStatevalues;
import communication.TresureStatevalues;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}playerPositionState"/>
 *         &lt;element ref="{}terrain"/>
 *         &lt;element ref="{}tresureState"/>
 *         &lt;element ref="{}fortState"/>
 *         &lt;element ref="{}X"/>
 *         &lt;element ref="{}Y"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
    "playerPositionState",
    "terrain",
    "tresureState",
    "fortState",
    "x",
    "y"
})
@XmlRootElement(name = "mapNode")
public class MapNode {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PlayerStatevalues playerPositionState;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TerrainStatevalues terrain;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TresureStatevalues tresureState;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected FortStatevalues fortState;
    @XmlElement(name = "X")
    protected int x;
    @XmlElement(name = "Y")
    protected int y;

    /**
     * Ruft den Wert der playerPositionState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PlayerStatevalues }
     *     
     */
    public PlayerStatevalues getPlayerPositionState() {
        return playerPositionState;
    }

    /**
     * Legt den Wert der playerPositionState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PlayerStatevalues }
     *     
     */
    public void setPlayerPositionState(PlayerStatevalues value) {
        this.playerPositionState = value;
    }

    /**
     * Ruft den Wert der terrain-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TerrainStatevalues }
     *     
     */
    public TerrainStatevalues getTerrain() {
        return terrain;
    }

    /**
     * Legt den Wert der terrain-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TerrainStatevalues }
     *     
     */
    public void setTerrain(TerrainStatevalues value) {
        this.terrain = value;
    }

    /**
     * Ruft den Wert der tresureState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TresureStatevalues }
     *     
     */
    public TresureStatevalues getTresureState() {
        return tresureState;
    }

    /**
     * Legt den Wert der tresureState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TresureStatevalues }
     *     
     */
    public void setTresureState(TresureStatevalues value) {
        this.tresureState = value;
    }

    /**
     * Ruft den Wert der fortState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FortStatevalues }
     *     
     */
    public FortStatevalues getFortState() {
        return fortState;
    }

    /**
     * Legt den Wert der fortState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FortStatevalues }
     *     
     */
    public void setFortState(FortStatevalues value) {
        this.fortState = value;
    }

    /**
     * Ruft den Wert der x-Eigenschaft ab.
     * 
     */
    public int getX() {
        return x;
    }

    /**
     * Legt den Wert der x-Eigenschaft fest.
     * 
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Ruft den Wert der y-Eigenschaft ab.
     * 
     */
    public int getY() {
        return y;
    }

    /**
     * Legt den Wert der y-Eigenschaft fest.
     * 
     */
    public void setY(int value) {
        this.y = value;
    }

}
