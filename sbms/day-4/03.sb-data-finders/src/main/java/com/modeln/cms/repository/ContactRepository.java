package com.modeln.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.modeln.cms.entity.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Integer> {

	Optional<Contact> findByContactName(String string);

	List<Contact> findByContactNumber(String string);

	Contact findByContactNameAndContactNumber(String string, String string2);
	
	//@Query("select contactName from com.modeln.cms.entity.Contact") //HQL
	@Query(value =  "select CONTACT_NAME from CONTACT_MASTER", nativeQuery = true) //SQL
	List<String> findAllContactNames();
	
	@Query("select contact from com.modeln.cms.entity.Contact contact where contactName = :cname")
	//@Query(value = "select * from CONTACT_MASTER where CONTACT_NAME=:cname", nativeQuery = true)
	Optional<Contact> findContactByName(String cname);

	@Query("select contactName cname from com.modeln.cms.entity.Contact where contactName like :matchName% ")
	List<String> findNamesWith(String matchName);

}
