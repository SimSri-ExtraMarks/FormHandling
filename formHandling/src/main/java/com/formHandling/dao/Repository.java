package com.formHandling.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.formHandling.entities.Data;


@Component("repository")
public interface Repository extends CrudRepository<Data, Integer>{

}
