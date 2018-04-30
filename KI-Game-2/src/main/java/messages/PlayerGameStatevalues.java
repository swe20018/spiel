//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 09:34:52 PM CEST 
//


package messages;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für playerGameStatevalues.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="playerGameStatevalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Won"/>
 *     &lt;enumeration value="Lost"/>
 *     &lt;enumeration value="ShouldActNext"/>
 *     &lt;enumeration value="ShouldWait"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "playerGameStatevalues")
@XmlEnum
public enum PlayerGameStatevalues {

    @XmlEnumValue("Won")
    WON("Won"),
    @XmlEnumValue("Lost")
    LOST("Lost"),
    @XmlEnumValue("ShouldActNext")
    SHOULD_ACT_NEXT("ShouldActNext"),
    @XmlEnumValue("ShouldWait")
    SHOULD_WAIT("ShouldWait");
    private final String value;

    PlayerGameStatevalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlayerGameStatevalues fromValue(String v) {
        for (PlayerGameStatevalues c: PlayerGameStatevalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
