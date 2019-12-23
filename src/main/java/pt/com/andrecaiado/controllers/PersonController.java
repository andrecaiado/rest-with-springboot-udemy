package pt.com.andrecaiado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.andrecaiado.data.model.Person;
import pt.com.andrecaiado.data.vo.PersonVO;
import pt.com.andrecaiado.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml"})
	public PersonVO findPersonById(@PathVariable("id") Long id) {
		return personServices.findById(id);
	}
	
	@GetMapping(produces = {"application/json","application/xml"})
	public List<PersonVO> findAll() {
		return personServices.findAll();
	}
	
	@PostMapping(produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public PersonVO create(@RequestBody PersonVO person) {
		return personServices.create(person);
	}
	
	@PutMapping(produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public PersonVO update(@RequestBody PersonVO person) {
		return personServices.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
