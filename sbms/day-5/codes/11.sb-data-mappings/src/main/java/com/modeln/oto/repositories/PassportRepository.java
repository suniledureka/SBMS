package com.modeln.oto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.oto.entities.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {

}
