package ch.teko.webengineering.business.contact.boundary;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.teko.webengineering.business.contact.controll.ContactsService;
import ch.teko.webengineering.business.contact.entity.Contact;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {
	
	private ContactsService service;
	
	public ContactsResource(ContactsService contactsService) {
		this.service = contactsService;
	}
	
	@POST
	public Response createContact(Contact contact) throws URISyntaxException {
		Contact newContact = service.createNewContact(contact);
		URI uri = new URI("/api/contact/" + newContact.getId());
		return Response.created(uri).build();
	}
	
	@GET
	public Response getAllContacts() {
		Collection<Contact> contactList = service.getAllContacts();
		return Response.ok(contactList).build();
	}

}
