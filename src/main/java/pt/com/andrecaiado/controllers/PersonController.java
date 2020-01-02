package pt.com.andrecaiado.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.com.andrecaiado.data.vo.PersonVO;
import pt.com.andrecaiado.services.PersonServices;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	@Autowired
	private PagedResourcesAssembler<PersonVO> assembler;
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVO = personServices.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public ResponseEntity<?> findAll(
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="limit", defaultValue="12") int limit,
			@RequestParam(value="direction", defaultValue="asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC; 
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));
		
		Page<PersonVO> persons = personServices.findAll(pageable);
		persons.stream().forEach( p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()) );
		
		PagedModel<?> resources = assembler.toModel(persons);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/findPersonByName/{firstName}",
			produces = {"application/json","application/xml","application/x-yaml"})
	public ResponseEntity<?> findPersonByName(
			@PathVariable(value="firstName") String firstName,
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="limit", defaultValue="12") int limit,
			@RequestParam(value="direction", defaultValue="asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC; 
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));
		
		Page<PersonVO> persons = personServices.findPersonByName(firstName, pageable);
		persons.stream().forEach( p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()) );
		
		PagedModel<?> resources = assembler.toModel(persons);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
		
	}
	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"},
			consumes = {"application/json","application/xml","application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVO = personServices.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}
	
	@PutMapping(produces = {"application/json","application/xml","application/x-yaml"},
			consumes = {"application/json","application/xml","application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVO = personServices.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}
	
	@PatchMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public PersonVO disablePerson(@PathVariable("id") Long id) {
		PersonVO personVO = personServices.disablePerson(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
