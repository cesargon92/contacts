package cl.cesar.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cesar.contacts.dao.ContactDAO;
import cl.cesar.contacts.dto.Contact;

@Service
public class ContactService {

	@Autowired
	ContactDAO dao;
	
	public Contact save(Contact contact) {
		return dao.saveAndFlush(contact);
	}
}
