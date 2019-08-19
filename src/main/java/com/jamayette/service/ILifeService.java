package com.jamayette.service;

import com.jamayette.model.Life;

import java.util.List;

public interface ILifeService {

	List<Life> findAllLife();

	Life findLifeByName(String name);

	boolean saveLife(Life life);

	Life findLifeById(Integer id);

	boolean editLife(Life life);

	Boolean deleteLife(Integer id);

}
