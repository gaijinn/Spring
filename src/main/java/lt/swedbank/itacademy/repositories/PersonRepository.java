package lt.swedbank.itacademy.repositories;

import lt.swedbank.itacademy.beans.documents.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findAll();
    Person findPersonById(String id);
    Person findPersonByName(String name);
    List<Person> findAllByLastNameStartsWith(String letter);
}
