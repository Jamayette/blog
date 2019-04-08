package com.jamayette.service;

import com.jamayette.model.Thoughts;

import java.util.List;

public interface IThoughtsService {

	List<Thoughts> findAllThoughts();

	Thoughts findThoughtsByName(String name);

	boolean saveThoughts(Thoughts thoughts);

	Thoughts findThoughtsById(Integer id);

	boolean editThoughts(Thoughts thoughts);

	Boolean deleteThoughts(Integer id);

}
