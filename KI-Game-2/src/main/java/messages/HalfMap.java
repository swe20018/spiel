//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 05:28:29 PM CEST 
//


package messages;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="uniquePlayerID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newMapNodes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="newMapNode" maxOccurs="32" minOccurs="32">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="X">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="7"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Y">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="fortPresent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="terrain" type="{}terraintype"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlRootElement(name = "halfMap")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
    "uniquePlayerID",
    "newMapNodes"
})

public class HalfMap {

    @XmlElement(required = true)
    protected String uniquePlayerID;
    @XmlElement(required = true)
    protected HalfMap.NewMapNodes newMapNodes;

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
     * Ruft den Wert der newMapNodes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HalfMap.NewMapNodes }
     *     
     */
    public HalfMap.NewMapNodes getNewMapNodes() {
        return newMapNodes;
    }

    /**
     * Legt den Wert der newMapNodes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HalfMap.NewMapNodes }
     *     
     */
    public void setNewMapNodes(HalfMap.NewMapNodes value) {
        this.newMapNodes = value;
    }


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
     *         &lt;element name="newMapNode" maxOccurs="32" minOccurs="32">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="X">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                         &lt;minInclusive value="0"/>
     *                         &lt;maxInclusive value="7"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Y">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                         &lt;minInclusive value="0"/>
     *                         &lt;maxInclusive value="3"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="fortPresent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="terrain" type="{}terraintype"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "newMapNode"
    })
    public static class NewMapNodes {

        @XmlElement(required = true)
        protected List<HalfMap.NewMapNodes.NewMapNode> newMapNode;

        /**
         * Gets the value of the newMapNode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the newMapNode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNewMapNode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HalfMap.NewMapNodes.NewMapNode }
         * 
         * 
         */
        public List<HalfMap.NewMapNodes.NewMapNode> getNewMapNode() {
            if (newMapNode == null) {
                newMapNode = new ArrayList<HalfMap.NewMapNodes.NewMapNode>();
            }
            return this.newMapNode;
        }


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
         *         &lt;element name="X">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *               &lt;minInclusive value="0"/>
         *               &lt;maxInclusive value="7"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Y">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *               &lt;minInclusive value="0"/>
         *               &lt;maxInclusive value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="fortPresent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="terrain" type="{}terraintype"/>
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
            "x",
            "y",
            "fortPresent",
            "terrain"
        })
        public static class NewMapNode {

            @XmlElement(name = "X")
            protected int x;
            @XmlElement(name = "Y")
            protected int y;
            protected boolean fortPresent;
            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected Terraintype terrain;

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

            /**
             * Ruft den Wert der fortPresent-Eigenschaft ab.
             * 
             */
            public boolean isFortPresent() {
                return fortPresent;
            }

            /**
             * Legt den Wert der fortPresent-Eigenschaft fest.
             * 
             */
            public void setFortPresent(boolean value) {
                this.fortPresent = value;
            }

            /**
             * Ruft den Wert der terrain-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Terraintype }
             *     
             */
            public Terraintype getTerrain() {
                return terrain;
            }

            /**
             * Legt den Wert der terrain-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Terraintype }
             *     
             */
            public void setTerrain(Terraintype value) {
                this.terrain = value;
            }

        }

    }

}
