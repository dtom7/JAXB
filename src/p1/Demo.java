package p1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class Demo {

	public static void main(String[] args) throws JAXBException, IOException {

		Person person = new Person();
		person.setName("Test Name");
		person.setGender("Male");
		person.setDob(new Date());

		Address address1 = new Address("HOME", "233 McKays Ct", "", "",
				"Brentwood", "TN", "37027");
		Address address2 = new Address("OFFICE", "123 Main St", "", "",
				"Franklin", "TN", "37020");
		List<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);
		person.setAddresses(addresses);

		Phone phone1 = new Phone("CELL", "654-897-2587");
		Phone phone2 = new Phone("HOME", "154-582-5478");
		List<Phone> phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);
		person.setPhones(phones);

		File file = new File("C:\\temp\\file.xml");

		JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
		
		SchemaOutputResolver sor = new MySchemaOutputResolver();
		jaxbContext.generateSchema(sor);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(person, file);

	}

	static class MySchemaOutputResolver extends SchemaOutputResolver {

		public Result createOutput(String namespaceURI, String suggestedFileName)
				throws IOException {
			File file = new File(suggestedFileName);
			StreamResult result = new StreamResult(file);
			result.setSystemId(file.toURI().toURL().toString());
			return result;
		}

	}

}
