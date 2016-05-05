package ch.teko.webengineering.business.contact.controll;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import ch.teko.webengineering.business.contact.entity.Contact;

public class ContactsService {
	
	private final Map<Long, Contact> contacts = new ConcurrentHashMap<Long, Contact>();
	private final AtomicLong contactSequenz = new AtomicLong(0);
	
	
	public Contact createNewContact(Contact contact) {
		Long id = contactSequenz.incrementAndGet();
		contact.setId(id);
		contacts.put(id, contact);
		return contact;
	}
	
	public Collection<Contact> getAllContacts() {
		return contacts.values();
	}
	
	public Contact getOneContact(Long id) {
		return contacts.get(id);
	}
	
	public void updateContact(Contact contact) {
		Long id = contact.getId();
		contacts.put(id, contact);
	}
	
	public void deleteContact(Long id) {
		contacts.remove(id);
	}

}
