package com.barriaza.springtutorial.moduloa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barriaza.springtutorial.moduloa.dao.PersonDAO;
import com.barriaza.springtutorial.moduloa.model.domain.Person;
import com.barriaza.springtutorial.moduloa.service.PersonService;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDao;
	
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}

	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	public List<Person> listPersons() {
		return personDao.listPersons();
	}

	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}

	public void removePerson(int id) {
		personDao.removePerson(id);
	}

}
