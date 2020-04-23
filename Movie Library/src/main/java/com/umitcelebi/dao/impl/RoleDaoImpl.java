package com.umitcelebi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.RoleDao;
import com.umitcelebi.model.Role;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	@Override
	public boolean addRole(Role role) {
		try {
			getSession().save(role);
			return true;
		} catch (Exception e) {
			System.out.println("Error saving role... "+e);
			return false;
		}
	}
	
	@Override
	public List<Role> searchByMovie(int movieId) {
		try {
			Query<Role> query=getSession().createQuery("from Role where movie.movieId =:movieId");
			query.setParameter("movieId", movieId);
			List<Role> roles=query.getResultList();
			return roles;
		} catch (Exception e) {
			System.out.println("Error searching... "+e);
			return null;
		}
	}
	@Override
	public List<Role> searchByActor(String actorName) {
		try {
			Query<Role> query=getSession().createQuery("from Role where actor.actorName =:actorname");
			query.setParameter("actorname", actorName);
			List<Role> roles=query.getResultList();
			return roles;
		} catch (Exception e) {
			System.out.println("Error searching... "+e);
			return null;
		}
	}
	@Override
	public boolean deleteRole(int movieId, int actorId) {
		try {
			Query<Role> query=getSession().createQuery("Delete Role  where movie.movieId =:movieId and actor.id =:actorId");
			query.setParameter("movieId", movieId);
			query.setParameter("actorId", actorId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error saving role... "+e);
			return false;
		}
	}
	@Override
	public boolean deleteRMovie(int movieId) {
		try {
			Query<Role> query=getSession().createQuery("Delete Role  where movie.movieId =:movieId");
			query.setParameter("movieId", movieId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error saving role... "+e);
			return false;
		}
	}
	@Override
	public boolean deleteRActor(int actorId) {
		try {
			Query<Role> query=getSession().createQuery("Delete Role  where actor.id =:actorId");
			query.setParameter("actorId", actorId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error saving role... "+e);
			return false;
		}
	}
	
	
}
