package com.jamayette.service.impl;

import com.jamayette.mapper.MovieMapper;
import com.jamayette.model.Movie;
import com.jamayette.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	MovieMapper movieMapper;

	@Override
	public List<Movie> findAllMovies() {
		Example example = new Example(Movie.class);
		example.setOrderByClause("id desc");
		List<Movie> movieList = movieMapper.selectByExample(example);
		List<Movie> showList = new ArrayList<>();
		for (Movie movie : movieList) {
			if (movie.getStatus() != 0) {
				showList.add(movie);
			}
		}
		return showList;
	}

	@Override
	public Movie findMovieByName(String name) {
		Movie record = new Movie();
		record.setName(name);
		return movieMapper.selectOne(record);
	}

	@Override
	public boolean saveMovie(Movie movie) {
		try {
			movie.setStatus(1);
			movieMapper.insert(movie);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editMovie(Movie movie) {
		try {
			movieMapper.updateByPrimaryKeySelective(movie);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Movie findMoiveById(Integer id) {
		return movieMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean deleteMovie(Integer id) {
		try {
			Movie movie = movieMapper.selectByPrimaryKey(id);
			movie.setStatus(0);
			movieMapper.updateByPrimaryKey(movie);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
