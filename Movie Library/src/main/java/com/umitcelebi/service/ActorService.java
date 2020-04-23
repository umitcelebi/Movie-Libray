package com.umitcelebi.service;

import java.util.List;

import com.umitcelebi.model.Actor;

public interface ActorService {
	
	List<Actor> allActors();
	List<Actor> actorsByName(String name);
	Actor actorById(int actorId);
	
	boolean addActor(Actor actor);
	boolean deleteActor(int actorId);
	boolean updateActor(Actor actor);
}
