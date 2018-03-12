package lt.swedbank.itacademy.controllers;


import lt.swedbank.itacademy.beans.documents.Person;
import lt.swedbank.itacademy.beans.responses.PersonResponse;
import lt.swedbank.itacademy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    public PersonResponse getPerson(@PathVariable(value = "id") String id) {
        return new PersonResponse(service.getPerson(id));
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public PersonResponse addNewPerson(@Valid @RequestBody Person person) {
        return new PersonResponse(service.newPerson(person));
    }

    @RequestMapping(path = "/person/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@Valid @PathVariable(value = "id") String id, @RequestBody Person person) {
        return service.updatePerson(person, id);
    }

    @RequestMapping(path = "/person/delete/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable(value = "id") String id) {
        service.removePerson(id);
    }

    @RequestMapping(path = "/person/all", method = RequestMethod.GET)
    public List<PersonResponse> getAllPersons() {
        return service.getAllPersons();
    }

    @RequestMapping(path = "/person/{name}", method = RequestMethod.GET)
    public Person getPersonByName(@PathVariable(value = "name") String name){
        return service.findPersonByName(name);
    }

    @RequestMapping(path = "/person/getBy/{letter}", method = RequestMethod.GET)
    public List<PersonResponse> getAllPersonByLastNameStartsWith(@PathVariable(value = "letter") String letter){
        return service.getAllPersonByLastNameStartsWith(letter.toUpperCase());
    }

}
