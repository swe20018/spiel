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
 * <p>Java-Klasse für fortStatevalues.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="fortStatevalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoOrUnknownFortState"/>
 *     &lt;enumeration value="MyFortPresent"/>
 *     &lt;enumeration value="EnemyFortPresent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fortStatevalues")
@XmlEnum
public enum FortStatevalues {

    @XmlEnumValue("NoOrUnknownFortState")
    NO_OR_UNKNOWN_FORT_STATE("NoOrUnknownFortState"),
    @XmlEnumValue("MyFortPresent")
    MY_FORT_PRESENT("MyFortPresent"),
    @XmlEnumValue("EnemyFortPresent")
    ENEMY_FORT_PRESENT("EnemyFortPresent");
    private final String value;

    FortStatevalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FortStatevalues fromValue(String v) {
        for (FortStatevalues c: FortStatevalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
