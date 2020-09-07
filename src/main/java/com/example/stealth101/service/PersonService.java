package com.example.stealth101.service;

import com.example.stealth101.model.Person;
import com.example.stealth101.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Instantiate with @Component or @repository (Needed for di & spring)
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person) {
         personRepository.save(person);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deletePerson(UUID id){
        personRepository.deleteById(id);
    }

    public void updatePerson(UUID id, Person person){
        Optional<Person> personExists = personRepository.findById(id);
        if (!personExists.isEmpty()) {
            person.setId(id);
            personRepository.save(person);
        }
    }
}
