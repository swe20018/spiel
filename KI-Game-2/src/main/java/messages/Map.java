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
 *         &lt;element ref="{}mapNodes"/>
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
    "mapNodes"
})
@XmlRootElement(name = "map")
public class Map {

    @XmlElement(required = true)
    protected MapNodes mapNodes;

    /**
     * Ruft den Wert der mapNodes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MapNodes }
     *     
     */
    public MapNodes getMapNodes() {
        return mapNodes;
    }

    /**
     * Legt den Wert der mapNodes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MapNodes }
     *     
     */
    public void setMapNodes(MapNodes value) {
        this.mapNodes = value;
    }

}
