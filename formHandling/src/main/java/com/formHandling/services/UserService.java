package com.formHandling.services;

import java.util.List;

import com.formHandling.entities.Data;

public interface UserService {
	List<Data> getAllDatas();
	Data getDataById(int id);
	Data updateData(Data data);
	Data saveData(Data data);
}
