//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 05:29:55 PM CEST 
//


package communication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}move"/>
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
    "move"
})
@XmlRootElement(name = "avatarMove")
public class AvatarMove {

    @XmlElement(required = true)
    protected String uniquePlayerID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MoveValues move;

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
     * Ruft den Wert der move-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MoveValues }
     *     
     */
    public MoveValues getMove() {
        return move;
    }

    /**
     * Legt den Wert der move-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MoveValues }
     *     
     */
    public void setMove(MoveValues value) {
        this.move = value;
    }

}
