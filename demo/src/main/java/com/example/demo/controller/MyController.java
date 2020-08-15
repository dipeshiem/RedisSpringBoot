package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("MyController")
public class MyController {

    private PersonRepository personRepository;

    public MyController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(path = "/feigngetAlltrades")
    public String getmyNAme(){

        return  "dipesh";
    }

@PostMapping("/save")
public ResponseEntity<String> save(@RequestParam String firstName, @RequestParam String lastName) {
    if(firstName == null) {
        return ResponseEntity.badRequest().build();
    }
    Person person = new Person.PersonBuilder().withFirstName(firstName).withLastName(lastName).
            withAddress(new Address.AddressBuilder().withCity("noida").withStreet("test").build()).build();

    Person savedPerson = personRepository.save(person);
    return ResponseEntity.ok(savedPerson.getId());
}

    @GetMapping("/get/{firstName}")
    public ResponseEntity<String> getByFirstName(@PathVariable ("firstName") String firstName ) {
        if(firstName == null) {
            return ResponseEntity.badRequest().build();
        }

        Person savedPerson = personRepository.findByFirstname(firstName).get(0);
        return ResponseEntity.ok(savedPerson.getFirstname());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<String> getByFirstId(@PathVariable ("id") String id ) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        Person savedPerson = personRepository.findById(id).get();
        return ResponseEntity.ok(savedPerson.getFirstname());
    }


}
