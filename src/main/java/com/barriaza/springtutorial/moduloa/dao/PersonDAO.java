package com.barriaza.springtutorial.moduloa.dao;

import java.util.List;

import com.barriaza.springtutorial.moduloa.model.domain.Person;

public interface PersonDAO {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);

}
