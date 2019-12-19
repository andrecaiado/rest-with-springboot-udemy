package pt.com.andrecaiado.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.andrecaiado.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("André");
		person.setLastName("Caiado");
		person.setGender("Male");
		person.setAddress("Rua Mestre António Nelas, Lote 191-A, 3º esq., 3510-596, Viseu");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setGender("Male");
		person.setAddress("Viseu " + i);
		return person;
	}
	
	public Person create(Person person) {
		person.setId(counter.incrementAndGet());
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
	}
	
}
