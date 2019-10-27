package cl.cesar.contacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cesar.contacts.dto.Contact;

public interface ContactDAO extends JpaRepository<Contact, Long> {

}
