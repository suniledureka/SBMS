package com.modeln.oto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.oto.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
