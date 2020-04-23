package com.umitcelebi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.ActorDao;
import com.umitcelebi.model.Actor;
import com.umitcelebi.service.ActorService;

@Service
@Transactional
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	private ActorDao actorDao;
	
	@Override
	public List<Actor> allActors() {
		
		return actorDao.allActors();
	}

	@Override
	public List<Actor> actorsByName(String name) {
		
		return actorDao.actorsByName(name);
	}

	@Override
	public Actor actorById(int actorId) {
		
		return actorDao.actorById(actorId);
	}

	@Override
	public boolean addActor(Actor actor) {
		
		return actorDao.addActor(actor);
	}

	@Override
	public boolean deleteActor(int actorId) {
		
		return actorDao.deleteActor(actorId);
	}

	@Override
	public boolean updateActor(Actor actor) {
		
		return actorDao.updateActor(actor);
	}

}
