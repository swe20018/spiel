//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 05:28:29 PM CEST 
//


package communication;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für terraintype.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="terraintype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Grass"/>
 *     &lt;enumeration value="Water"/>
 *     &lt;enumeration value="Mountain"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "terraintype")
@XmlEnum
public enum Terraintype {

    @XmlEnumValue("Grass")
    GRASS("Grass"),
    @XmlEnumValue("Water")
    WATER("Water"),
    @XmlEnumValue("Mountain")
    MOUNTAIN("Mountain");
    private final String value;

    Terraintype(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Terraintype fromValue(String v) {
        for (Terraintype c: Terraintype.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
