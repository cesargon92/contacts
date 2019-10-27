package cl.cesar.contacts.controller;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.cesar.contacts.dto.Contact;
import cl.cesar.contacts.dto.ContactRequest;
import cl.cesar.contacts.dto.ContactResponse;
import cl.cesar.contacts.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService service;
	
	@Autowired
	Mapper mapper;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public Contact getById() {
		return new Contact(1L, "Cesar", "Gonzalez", "+56 9 66779175", "cesar.gonzalez.992@gmail.com");
	}
	
	@RequestMapping(value="contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody @Valid ContactRequest contactRequest) {
		//Mapea los atributos del dto request con los del DTO entidad
		Contact contact = mapper.map(contactRequest, Contact.class);
		
		// se invoca a la lógica de negocio en el service
		Contact updatedContact = service.save(contact);
		
		// mapea los atributos del DTO entidad con los atributos del DTO Response
		ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class);
		
		return contactResponse;
	}
	
}
