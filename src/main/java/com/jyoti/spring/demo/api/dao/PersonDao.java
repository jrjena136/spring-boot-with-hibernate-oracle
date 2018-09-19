package com.jyoti.spring.demo.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jyoti.spring.demo.api.model.Person;

@Repository
@Transactional
public class PersonDao {
	
	@Autowired
	private SessionFactory factory;
	
	
	public void savePersion(Person person) {
		getSession().save(person);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getListOfPersions(){
		return getSession().createCriteria(Person.class).list();
	}
	public Person getPersionById(String pId) {
		Query query = getSession().createQuery("FROM Person WHERE ID=:id");
		query.setString("id", pId);
		Person p = (Person) query.uniqueResult();
		System.out.println("Person : " + p.toString());
		
		return p;
	}
	private Session getSession() {
		Session session = factory.getCurrentSession();
		if(session == null) {
			session = factory.openSession();
		}
		return session;
	}

	

}
