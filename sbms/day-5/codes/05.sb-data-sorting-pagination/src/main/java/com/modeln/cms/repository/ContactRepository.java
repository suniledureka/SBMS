package com.modeln.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modeln.cms.entity.Contact;

@Repository //optional
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByOrderByContactNameAsc();

	List<Contact> findByOrderByContactNameDesc();
}
