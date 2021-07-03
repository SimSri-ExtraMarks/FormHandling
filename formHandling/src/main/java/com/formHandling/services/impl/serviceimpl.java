package com.formHandling.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formHandling.dao.Repository;
import com.formHandling.entities.Data;
import com.formHandling.services.UserService;

@Service
public class serviceimpl implements UserService{
	private Repository repository;
	
	public serviceimpl(Repository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<Data> getAllDatas() {
		return repository.findAll();
	}

	@Override
	public Data saveData(Data data) {
		return repository.save(data);
	}

	@Override
	public Data getDataById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Data updateData(Data data) {
		return repository.save(data);
	}
}
