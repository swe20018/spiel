//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.15 um 09:34:52 PM CEST 
//


package communication;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für playerStatevalues.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="playerStatevalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoPlayerPresent"/>
 *     &lt;enumeration value="EnemyPlayerPosition"/>
 *     &lt;enumeration value="MyPosition"/>
 *     &lt;enumeration value="BothPlayerPosition"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "playerStatevalues")
@XmlEnum
public enum PlayerStatevalues {

    @XmlEnumValue("NoPlayerPresent")
    NO_PLAYER_PRESENT("NoPlayerPresent"),
    @XmlEnumValue("EnemyPlayerPosition")
    ENEMY_PLAYER_POSITION("EnemyPlayerPosition"),
    @XmlEnumValue("MyPosition")
    MY_POSITION("MyPosition"),
    @XmlEnumValue("BothPlayerPosition")
    BOTH_PLAYER_POSITION("BothPlayerPosition");
    private final String value;

    PlayerStatevalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlayerStatevalues fromValue(String v) {
        for (PlayerStatevalues c: PlayerStatevalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
