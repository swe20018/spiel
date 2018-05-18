package dataobjects;

import org.junit.experimental.theories.Theories;

public class PlayerInformation {

	private String matNr;
	private String firstName;
	private String lastName;
	
	public PlayerInformation (String matNr, String firstName, String lastName) {
		this.matNr = matNr;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	// default information
	public PlayerInformation () {
		this.matNr = "a1063229";
		this.firstName = "Jennifer";
		this.lastName = "Posch";
	}
	public String getMatnr() {
		return this.matNr;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setMatnr(String matNr) {
		this.matNr = matNr;
		return;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		return;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		return;
	}  
}
