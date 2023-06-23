package com.example.wsbfinalproject2023.services;


import com.example.wsbfinalproject2023.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    final private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public void saveAdmin(){
        String username = "admin";
        String password = "aA123456";

        Optional<Person> person = personRepository.findByUsername(username);

        if (person.isPresent()){
            System.out.println("Użytkownik administracyjny już z istnieje, przerywam");
            return;

        }
        System.out.println("Tworzymy uzytkownika administracyjnego");

        Person newPerson = new Person();
        newPerson.setUsername(username);
        newPerson.setRealName(username);
        newPerson.setPassword(username);

        personRepository.save(newPerson);

    }
}