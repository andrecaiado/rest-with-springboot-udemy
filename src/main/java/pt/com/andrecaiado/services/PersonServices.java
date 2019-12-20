package pt.com.andrecaiado.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.andrecaiado.converter.DozerConverter;
import pt.com.andrecaiado.data.model.Person;
import pt.com.andrecaiado.data.vo.PersonVO;
import pt.com.andrecaiado.exceptions.ResourceNotFoundException;
import pt.com.andrecaiado.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		repository.delete(entity);
	}
	
}
