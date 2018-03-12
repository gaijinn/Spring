package lt.swedbank.itacademy.services;

import lt.swedbank.itacademy.beans.documents.Person;
import lt.swedbank.itacademy.beans.responses.PersonResponse;
import lt.swedbank.itacademy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person getPerson(String id){
        return repository.findPersonById(id);
    }

    public Person newPerson(@Valid Person person){
        return repository.save(person);
    }

    public Person updatePerson(Person personUpdateInfo, String id){
        Person person = repository.findPersonById(id);
        person.setName(personUpdateInfo.getName());
        person.setLastName(personUpdateInfo.getLastName());
        person.setAge(personUpdateInfo.getAge());
        person.setHeight(personUpdateInfo.getHeight());
        return repository.save(person);
    }

    public void removePerson(String id) {
        repository.delete(repository.findPersonById(id));
    }

    public List<PersonResponse> getAllPersons(){
        return repository.findAll().stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }

    public Person findPersonByName(String name){
        return repository.findPersonByName(name);
    }

    public List<PersonResponse> getAllPersonByLastNameStartsWith(String letter){
        return repository.findAllByLastNameStartsWith(letter).stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }
}
