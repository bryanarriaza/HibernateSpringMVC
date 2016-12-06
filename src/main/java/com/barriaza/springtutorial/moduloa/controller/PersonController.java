package com.barriaza.springtutorial.moduloa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barriaza.springtutorial.moduloa.model.domain.Person;
import com.barriaza.springtutorial.moduloa.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", personService.listPersons());
		return "person";
	}

	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {
		if (p.getId() == 0) {
			// new person, add it
			this.personService.addPerson(p);
		} else {
			// existing person, call update
			this.personService.updatePerson(p);
		}
		return "redirect:/persons";
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {
		this.personService.removePerson(id);
		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		System.out.println(this.personService.getPersonById(id).getName());
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
}
