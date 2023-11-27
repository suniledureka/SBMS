package com.modeln.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modeln.students.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}