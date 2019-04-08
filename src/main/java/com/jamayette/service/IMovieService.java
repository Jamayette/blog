package com.jamayette.service;

import com.jamayette.model.Movie;

import java.util.List;

public interface IMovieService {

	List<Movie> findAllMovies();

	Movie findMovieByName(String name);

	boolean saveMovie(Movie movie);

	boolean editMovie(Movie movie);

	Movie findMoiveById(Integer id);

	Boolean deleteMovie(Integer id);

}
