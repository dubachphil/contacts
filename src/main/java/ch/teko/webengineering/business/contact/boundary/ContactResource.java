package ch.teko.webengineering.business.contact.boundary;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.teko.webengineering.business.contact.controll.ContactsService;
import ch.teko.webengineering.business.contact.entity.Contact;

@Path("/contact/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
	
	private ContactsService service;
	
	public ContactResource(ContactsService contactsService) {
		this.service = contactsService;
	}
	
	@GET
	public Response getOneContact(@PathParam("id") Long id) {
		Contact contact = service.getOneContact(id);
		return Response.ok(contact).build();
	}
	
	@DELETE
	public Response deleteContact(@PathParam("id") Long id) {
		service.deleteContact(id);
		return Response.ok().build();
	}
	
	@PUT
	public Response updateContact(@PathParam("id") Long id, Contact contact) {
		contact.setId(id);
		service.updateContact(contact);
		return Response.ok(contact).build();
	}
	

}
