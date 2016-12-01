package com.barriaza.springtutorial.moduloa.service;

import java.util.List;

import com.barriaza.springtutorial.moduloa.model.domain.Person;

public interface PersonService {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);

}
