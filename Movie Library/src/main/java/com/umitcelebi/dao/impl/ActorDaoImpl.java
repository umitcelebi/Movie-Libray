package com.umitcelebi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.ActorDao;
import com.umitcelebi.model.Actor;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class ActorDaoImpl implements ActorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Actor> allActors() {
		try {
			Query<Actor> query=getSession().createQuery("from Actor");
			List<Actor> allActor=query.getResultList();
			return allActor;
		} catch (Exception e) {
			System.out.println("Error showing actor..."+e);
			return null;
		}
	}

	@Override
	public List<Actor> actorsByName(String name) {
		try {
			Query<Actor> query=getSession().createQuery("from Actor where actorName =:name");
			query.setParameter("name", name);
			List<Actor> allActor=query.getResultList();
			return allActor;
		} catch (Exception e) {
			System.out.println("Error showing actor..."+e);
			return null;
		}
	}

	@Override
	public Actor actorById(int actorId) {
		try {
			Query<Actor> query=getSession().createQuery("from Actor where id =:id");
			query.setParameter("id", actorId);
			Actor actor=query.getSingleResult();
			return actor;
		} catch (Exception e) {
			System.out.println("Error showing actor..."+e);
			return null;
		}
	}

	@Override
	public boolean addActor(Actor actor) {
		try {
			getSession().save(actor);
			return true;
		} catch (Exception e) {
			System.out.println("Error adding actor..."+e);
			return false;
		}
	}

	@Override
	public boolean deleteActor(int actorId) {
		try {
			Query<Actor> query=getSession().createQuery("delete from Actor a  where a.id=:Id");
			query.setParameter("Id", actorId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error delete movie..."+e);
			return false;
		}
	}

	@Override
	public boolean updateActor(Actor actor) {
		try {
			getSession().update(actor);
			return true;
		} catch (Exception e) {
			System.out.println("Error updating movie..."+e);
			return false;
		}
		
	}

}
