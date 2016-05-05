package ch.teko.webengineering.contacts;

import ch.teko.webengineering.business.contact.boundary.ContactsResource;
import ch.teko.webengineering.business.contact.controll.ContactsService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ContactsApplication extends Application<ContactsConfiguration>{
	
	public static void main(String[] args) throws Exception {
		new ContactsApplication().run(args);
	}

	@Override
	public void run(ContactsConfiguration contactsConfiguration, Environment environment) throws Exception {
		ContactsService contactsService = new ContactsService();
		environment.jersey().register(new ContactsResource(contactsService));
	
	}

}
