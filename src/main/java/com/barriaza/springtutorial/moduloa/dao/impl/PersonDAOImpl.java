package com.barriaza.springtutorial.moduloa.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barriaza.springtutorial.moduloa.dao.PersonDAO;
import com.barriaza.springtutorial.moduloa.model.domain.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	private SessionFactory sessionFactory;

	@Autowired
	public PersonDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPerson(Person person) {
		getCurrentSession().persist(person);
		logger.info("Person saved successfully, Person Details= " + person);
	}

	public void updatePerson(Person person) {
		getCurrentSession().update(person);
		logger.info("Person updated successfully, Person Details= " + person);
	}


	@SuppressWarnings({ "unchecked" })
	public List<Person> listPersons() {
		logger.info("List all persons");
		return getCurrentSession().createQuery("from Person").list();
	}

	public Person getPersonById(int id) {
		logger.info("List only person by id");
		return (Person) getCurrentSession().load(Person.class, new Integer(id));
	}

	public void removePerson(int id) {
		getCurrentSession().delete(getCurrentSession().load(Person.class, new Integer(id)));
	}

}
