package com.modeln.multi.db2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.multi.db2.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
