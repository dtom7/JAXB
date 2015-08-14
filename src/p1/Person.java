package p1;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "gender", "dob", "addresses", "phones" })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	private String name;
	private String gender;
	private Date dob;
	@XmlElementWrapper(name = "addresses")
	@XmlElement(name = "address")
	private List<Address> addresses;
	@XmlElementWrapper(name = "phones")
	@XmlElement(name = "phone")
	private List<Phone> phones;

	public Person(String name, String gender, Date dob,
			List<Address> addresses, List<Phone> phones) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.addresses = addresses;
		this.phones = phones;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
