package com.example.lesson14.webcontroller;

import com.example.lesson14.domain.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController
{
    private List<Person> addressBook = new ArrayList<>();

    @GetMapping
    public List<Person> showAddressBook()
    {
        return addressBook;
    }

    @PostMapping()
    public ResponseEntity<Person> addPerson(@RequestBody Person person)
    {
        person.setId(addressBook.size());
        addressBook.add(person);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public Person showPerson(@PathVariable int id)
    {
        return addressBook.stream().filter(person -> person.getId() == id).findFirst().orElseThrow();
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id)
    {
        addressBook.removeIf(person -> person.getId() == id);
        return "Person " + id + "was deleted";
    }

    @PutMapping("/{id}")
    public Person editPerson(@PathVariable int id, @RequestBody Person person)
    {
        addressBook.remove(id);
        person.setId(id);
        addressBook.add(id, person);
        return person;
    }

    @GetMapping("/find/{name}")
    public Person showPersonByName(@PathVariable String name)
    {
        return addressBook.stream().filter(person -> person.getName().equals(name)).findFirst().orElseThrow();
    }
}
