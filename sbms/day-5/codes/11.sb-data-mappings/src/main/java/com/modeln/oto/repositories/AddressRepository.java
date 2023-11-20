package com.modeln.oto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.oto.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
