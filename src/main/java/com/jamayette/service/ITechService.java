package com.jamayette.service;

import com.jamayette.model.Tech;

import java.util.List;

public interface ITechService {

	List<Tech> findAllTechs();

	Tech findTechByName(String name);

	boolean saveTech(Tech tech);

	Boolean deleteTech(Integer id);

	Tech findTechById(Integer id);

	boolean editTech(Tech tech);

}
