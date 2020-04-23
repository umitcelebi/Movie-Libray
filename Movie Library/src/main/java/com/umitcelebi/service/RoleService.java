package com.umitcelebi.service;

import java.util.List;

import com.umitcelebi.model.Role;

public interface RoleService {
	boolean addRole(Role role);
	List<Role> searchByMovie(int movieId);
	List<Role> searchByActor(String actorName);

	boolean deleteRole(int movieId,int actorId);
	boolean deleteRMovie(int movieId);
	boolean deleteRActor(int actorId);
}
