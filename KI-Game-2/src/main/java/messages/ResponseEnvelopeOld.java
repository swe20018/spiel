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

import messages.ResponseState;

/**
 * <p>
 * Java-Klasse für anonymous complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="exceptionMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state" type="{}statevalues"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "exceptionName", "exceptionMessage", "state", "data" })
@XmlRootElement(name = "ResponseEnvelope")

public class ResponseEnvelopeOld<T> {

	@XmlElement(name = "exceptionMessage")
	private String exceptionMessage;

	@XmlElement(name = "exceptionName")
	private String exceptionName;

	@XmlElement(name = "state")
	private ResponseState state;

	@XmlElement(name = "data")
	private T data;

	public ResponseEnvelopeOld() {
		state = ResponseState.OK;
		this.data = null;

		exceptionMessage = "";
		exceptionName = "";
	}

	public ResponseEnvelopeOld(T data) {
		state = ResponseState.OK;
		this.data = data;

		exceptionMessage = "";
		exceptionName = "";
	}

	/**
	 * Ruft den Wert der exceptionName-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExceptionName() {
		return exceptionName;
	}

	/**
	 * Legt den Wert der exceptionName-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExceptionName(String value) {
		this.exceptionName = value;
	}

	/**
	 * Ruft den Wert der exceptionMessage-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * Legt den Wert der exceptionMessage-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExceptionMessage(String value) {
		this.exceptionMessage = value;
	}

	/**
	 * Ruft den Wert der state-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Statevalues }
	 * 
	 */
	public ResponseState getState() {
		return state;
	}

	/**
	 * Legt den Wert der state-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link Statevalues }
	 * 
	 */
	public void setState(ResponseState value) {
		this.state = value;
	}

	/**
	 * Ruft den Wert der data-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public T getData() {
		return data;
	}

	/**
	 * Legt den Wert der data-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setData(T value) {
		this.data = value;
	}

}
