package lt.swedbank.itacademy.beans.responses;

import lt.swedbank.itacademy.beans.documents.Person;

public class PersonResponse extends Response {

    private String id;
    private String name;
    private String lastName;

    public PersonResponse(Person person) {
        this.id = String.valueOf(person.getId());
        this.name = person.getName();
        this.lastName = person.getLastName();
    }

    public PersonResponse(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
