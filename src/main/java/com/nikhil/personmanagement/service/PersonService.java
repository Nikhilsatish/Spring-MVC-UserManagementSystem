package com.nikhil.personmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.personmanagement.dao.PersonDao;
import com.nikhil.personmanagement.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	// We validate in service
	// Insert
	public boolean savePerson(Person person) {
		if (person != null) {
			dao.savePerson(person);
			return true;
		}
		return false;
	}

	// Find by ID
	public Person findPerson(int personId) {
		Person obj = dao.findperson(personId);
		if (obj != null) {
			return obj;
		}
		return null;
	}

	// update
	public void updatePerson(Person person) {

		int id = person.getPersonId();

		Person person2 = findPerson(id);

		if (person2 != null && person != null) {

			dao.updatePerson(person);
		}
	}

	// delete
	public boolean deletPerson(int id) {

		Person person = findPerson(id);

		if (person != null) {

			return dao.deletePerson(id);
		}
		return false;
	}

	// display all
	public List<Person> displayAll() {
		return dao.displayAll();
	}

}
