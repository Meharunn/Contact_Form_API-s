package com.Website.Contact.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Website.Contact.Model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
