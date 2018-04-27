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
 * <p>Java-Klasse für tresureStatevalues.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tresureStatevalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoOrUnknownTresureState"/>
 *     &lt;enumeration value="MyTresureIsPlacedHere"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tresureStatevalues")
@XmlEnum
public enum TresureStatevalues {

    @XmlEnumValue("NoOrUnknownTresureState")
    NO_OR_UNKNOWN_TRESURE_STATE("NoOrUnknownTresureState"),
    @XmlEnumValue("MyTresureIsPlacedHere")
    MY_TRESURE_IS_PLACED_HERE("MyTresureIsPlacedHere");
    private final String value;

    TresureStatevalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TresureStatevalues fromValue(String v) {
        for (TresureStatevalues c: TresureStatevalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
