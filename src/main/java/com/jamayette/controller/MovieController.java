package com.jamayette.controller;

import com.jamayette.model.Movie;
import com.jamayette.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MovieController {

	@Autowired
	IMovieService movieService;

	@RequestMapping("/movie")
	public String findAll(Model model) {
		List<Movie> movieList = movieService.findAllMovies();
		model.addAttribute(movieList);
		return "movie/list";
	}

	@RequestMapping("/movie/{name}")
	public String findMovieById(Model model, @PathVariable String name) {
		Movie movie = movieService.findMovieByName(name);
		if (movie.getStatus() != 1) {
			return "/error/404";
		}
		model.addAttribute(movie);
		return "movie/detail";
	}

	@RequestMapping("/m/movie/create")
	public String createMovie() {
		return "movie/create";
	}

	@RequestMapping(value = "/m/movie/create/submit")
	public String saveMovie(Movie movie) {
		boolean b = movieService.saveMovie(movie);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

	@RequestMapping(value = "/m/movie/edit/{id}")
	public String editMovie(@PathVariable Integer id, Model model) {
		Movie movie = movieService.findMoiveById(id);
		model.addAttribute("movie", movie);
		return "movie/edit";
	}

	@RequestMapping(value = "/m/movie/edit/submit")
	public String editSubmit(Movie movie) {
		boolean b = movieService.editMovie(movie);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

	@RequestMapping(value = "/m/movie/delete/{id}")
	public String deleteMovie(@PathVariable Integer id) {
		Boolean b = movieService.deleteMovie(id);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

}
