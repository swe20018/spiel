package messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType (name = "nothingtoExpect")
@XmlAccessorType(XmlAccessType.NONE)
public class HalfMapAnswer {
	
	@XmlElement(name="nothingtoExpect")
	private final String nothingtoExpect;

	public HalfMapAnswer() {
		this.nothingtoExpect = "";
	}
	
	public HalfMapAnswer(String nothingtoExpect) {
		this.nothingtoExpect = nothingtoExpect;
	}
	
	public String getNnothingtoExpect() {
		return nothingtoExpect;
	}
}
