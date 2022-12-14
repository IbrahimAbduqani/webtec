package com.example.demo.web;

import com.example.demo.service.PersonService;
import com.example.demo.web.api.Person;
import com.example.demo.web.api.PersonManipulationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PersonRestController {
    private final PersonService personService;

    public PersonRestController(PersonService personRepository) {
        this.personService = personRepository;
    }


    @GetMapping(path = "/api/v1/persons")
      @ResponseStatus(code = HttpStatus.OK )
   public  ResponseEntity<List<Person>> fetchPersons(){
        return ResponseEntity.ok(personService.findAll());
     }
    @GetMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Person> fetchPersonById(@PathVariable Long id){
        var person = personService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }
     @PostMapping(path = "/api/v1/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonManipulationRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/v1/persons/" + person.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody PersonManipulationRequest request){
        var person = personService.update(id, request);

        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        boolean successful = personService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
