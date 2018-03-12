package lt.swedbank.itacademy;

import lt.swedbank.itacademy.beans.documents.Person;
import lt.swedbank.itacademy.beans.responses.PersonResponse;
import lt.swedbank.itacademy.repositories.PersonRepository;
import lt.swedbank.itacademy.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItAcademyApplicationTests {

    @Autowired
    private PersonService service;


    @Autowired
    private PersonRepository repository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void whenValidName_PersonShouldBeFound(){
        String name = "George";
        Person person = service.findPersonByName(name);

        Assert.assertEquals(person.getName(),name);
    }

    @Test
    public void whenValidId_PersonShouldBeFound(){
        String id = "5aa6ead2759c16429cef58b1";
        Person person = repository.findPersonById(id);

        Assert.assertEquals(person.getId().toString(),id);
    }

    @Test
    public void getAllPersonsByLastNameStartsWithLetter_G_ShouldReturn_2(){
        String letter = "G";
        List<PersonResponse> response = service.getAllPersonByLastNameStartsWith(letter);

        Assert.assertEquals(response.size(), 2);
    }

}
