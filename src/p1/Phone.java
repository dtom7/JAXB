package p1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
	
	private String phoneType;
	private String phoneNumber;
	
	public Phone(String phoneType, String phoneNumber) {
		super();
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	}
	
	public Phone() {
		super();
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
