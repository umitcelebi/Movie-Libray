package com.umitcelebi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.RoleDao;
import com.umitcelebi.model.Role;
import com.umitcelebi.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public boolean addRole(Role role) {
		
		return roleDao.addRole(role);
	}

	@Override
	public List<Role> searchByMovie(int movieId) {
		
		return roleDao.searchByMovie(movieId);
	}

	@Override
	public List<Role> searchByActor(String actorName) {
		
		return roleDao.searchByActor(actorName);
	}

	@Override
	public boolean deleteRole(int movieId, int actorId) {
		
		return roleDao.deleteRole(movieId, actorId);
	}

	@Override
	public boolean deleteRMovie(int movieId) {
		
		return roleDao.deleteRMovie(movieId);
	}

	@Override
	public boolean deleteRActor(int actorId) {
		
		return roleDao.deleteRActor(actorId);
	}


}
