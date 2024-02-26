package com.nikhil.personmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nikhil.personmanagement.entity.Person;

@Component
public class PersonDao {

	@Autowired
	private EntityManager entityManager;

	// Insert
	public void savePerson(Person person) {
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(person);
		et.commit();
	}

	// Find by Id
	public Person findperson(int personId) {
		Person obj = entityManager.find(Person.class, personId);
		return obj;
	}

	// update
	public void updatePerson(Person person) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(person);
		transaction.commit();
	}

	// delete
	public boolean deletePerson(int id) {

		Person person = findperson(id);

		if (person != null) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(person);
			transaction.commit();
			return true;
		}
		return false;

	}

	// All data
	public List<Person> displayAll() {

		Query query = entityManager.createQuery("from Person");
		List list = query.getResultList();
		return list;
	}

}
