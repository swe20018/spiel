//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 09:34:52 PM CEST 
//


package communication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import messages.PlayerGameStatevalues;


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
 *         &lt;element ref="{}uniquePlayerID"/>
 *         &lt;element ref="{}firstName"/>
 *         &lt;element ref="{}lastName"/>
 *         &lt;element ref="{}studentID"/>
 *         &lt;element name="state" type="{}playerGameStatevalues"/>
 *         &lt;element ref="{}collectedTreasure"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uniquePlayerID",
    "firstName",
    "lastName",
    "studentID",
    "state",
    "collectedTreasure"
})
@XmlRootElement(name = "player")
public class Player {

    @XmlElement(name = "uniquePlayerID", required = true)
    protected String uniquePlayerID;
    @XmlElement(name = "firstName", required = true)
    protected String firstName;
    @XmlElement(name = "lastName", required = true)
    protected String lastName;
    @XmlElement(name = "studentID", required = true)
    protected String studentID;
    @XmlElement(name = "state", required = true)
    @XmlSchemaType(name = "string")
    protected PlayerGameStatevalues state;
    @XmlElement(name = "collectedTreasure")
    protected boolean collectedTreasure;

    /**
     * Ruft den Wert der uniquePlayerID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniquePlayerID() {
        return uniquePlayerID;
    }

    /**
     * Legt den Wert der uniquePlayerID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniquePlayerID(String value) {
        this.uniquePlayerID = value;
    }

    /**
     * Ruft den Wert der firstName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Legt den Wert der firstName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Ruft den Wert der lastName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Legt den Wert der lastName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Ruft den Wert der studentID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Legt den Wert der studentID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudentID(String value) {
        this.studentID = value;
    }

    /**
     * Ruft den Wert der state-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PlayerGameStatevalues }
     *     
     */
    public PlayerGameStatevalues getState() {
        return state;
    }

    /**
     * Legt den Wert der state-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PlayerGameStatevalues }
     *     
     */
    public void setState(PlayerGameStatevalues value) {
        this.state = value;
    }

    /**
     * Ruft den Wert der collectedTreasure-Eigenschaft ab.
     * 
     */
    public boolean isCollectedTreasure() {
        return collectedTreasure;
    }

    /**
     * Legt den Wert der collectedTreasure-Eigenschaft fest.
     * 
     */
    public void setCollectedTreasure(boolean value) {
        this.collectedTreasure = value;
    }

}
