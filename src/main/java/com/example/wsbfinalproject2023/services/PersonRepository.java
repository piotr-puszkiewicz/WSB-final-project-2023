package com.example.wsbfinalproject2023.services;

import com.example.wsbfinalproject2023.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

     Optional<Person> findByUsername(String username);
}
