package com.umitcelebi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umitcelebi.dao.MovieDao;
import com.umitcelebi.model.Movie;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository
public class MovieDaoImpl implements MovieDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Movie> allMovie() {
		try {
			Query<Movie> query=getSession().createQuery("from Movie");
			List<Movie> allMovie=query.getResultList();
			return allMovie;
		} catch (Exception e) {
			System.out.println("Error showing actor..."+e);
			return null;
		}
	}

	@Override
	public List<Movie> movieByName(String name) {
		try {
			Query<Movie> query=getSession().createQuery("from Movie where movieName =:name");
			query.setParameter("name", name);
			List<Movie> allMovie=query.getResultList();
			return allMovie;
		} catch (Exception e) {
			System.out.println("Error showing movies..."+e);
			return null;
		}
	}

	@Override
	public List<Movie> movieByActor(String actor) {
		try {
			Query<Movie> query=getSession().createQuery("from Movie where actors.actorName =:name");
			query.setParameter("name", actor);
			List<Movie> allMovie=query.getResultList();
			return allMovie;
		} catch (Exception e) {
			System.out.println("Error showing movies..."+e);
			return null;
		}
	}

	@Override
	public List<Movie> movieByGenre(String genre) {
		try {
			Query<Movie> query=getSession().createQuery("from Movie where genre like :genre");
			query.setParameter("genre", "%"+genre+"%");
			List<Movie> allMovie=query.getResultList();
			return allMovie;
		} catch (Exception e) {
			System.out.println("Error showing movies..."+e);
			return null;
		}
	}

	@Override
	public List<Movie> orderByYear() {
		try {
			Query<Movie> query=getSession().createQuery("from Movie order by year asc");
			List<Movie> allMovie=query.getResultList();
			return allMovie;
		} catch (Exception e) {
			System.out.println("Error showing movies..."+e);
			return null;
		}
	}
	
	@Override
	public Movie movieById(int id) {
		try {
			Query<Movie> query=getSession().createQuery("from Movie where movieId =:id");
			query.setParameter("id", id);
			Movie movie=query.getSingleResult();
			return movie;
		} catch (Exception e) {
			System.out.println("Error showing movie..."+e);
			return null;
		}
	}

	@Override
	public Movie updateMovie(Movie film) {
		try {
			getSession().update(film);
			return film;
		} catch (Exception e) {
			System.out.println("Error update movie..."+e);
			return null;
		}
	}

	@Override
	public boolean addMovie(Movie movie) {
		try {
			getSession().save(movie);
			return true;
		} catch (Exception e) {
			System.out.println("Error adding movie..."+e);
			return false;
		}
	}

	@Override
	public boolean deleteMovie(int id) {
		try {
			Query<Movie> query=getSession().createQuery("delete from Movie m  where m.movieId=:Id");
			query.setParameter("Id", id);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Error delete movie..."+e);
			return false;
		}
	}


}
