package com.itachi.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itachi.springmvc.model.Alien;

@Component
public class AlienDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Alien> getAllAlien()
	{
		Session session = sessionFactory.getCurrentSession();
		List<Alien> aliens = session.createQuery("from Alien", Alien.class).list();
		System.out.println("asai hi");
		return aliens;
	}

}
