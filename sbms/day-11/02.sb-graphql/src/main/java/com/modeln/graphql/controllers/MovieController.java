package com.modeln.graphql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.modeln.graphql.models.Movie;
import com.modeln.graphql.repositories.MovieRepository;

@Controller
public class MovieController {
	
	private MovieRepository movieRepo;
	
	@Autowired
	public MovieController(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}
	
	@QueryMapping
	public Movie movieById(@Argument Integer id) {
		return movieRepo.getById(id);
	}
	
	@QueryMapping(name = "allMovies")
	public List<Movie> findAllMovies(){
		return movieRepo.getAllMovies();
	}
	
	@MutationMapping
    public Movie addMovie(@Argument Integer id, @Argument String title, @Argument Integer year, @Argument List<String> genres, @Argument String director) {
        Movie movie = new Movie(id, title, year, genres, director);
        movieRepo.addMovie(movie);
        return movie;
    }
}
