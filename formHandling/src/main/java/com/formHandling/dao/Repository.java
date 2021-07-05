package com.formHandling.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.formHandling.entities.Data;


@Component("repository")
public interface Repository extends JpaRepository<Data, Integer> {

}