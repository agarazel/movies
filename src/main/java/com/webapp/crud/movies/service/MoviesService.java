package com.webapp.crud.movies.service;

import com.webapp.crud.movies.model.Movie;
import com.webapp.crud.movies.model.MovieGenre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService implements IMoviesService {
  
  @Override
  public List<Movie> getAllMovies() {
    List<Movie> movies = new ArrayList<>();
    movies.add(new Movie("Pulp Fiction", MovieGenre.DRAMA));
    movies.add(new Movie("Pulp Fiction", MovieGenre.DRAMA));
    return movies;
  }
  
}
