package com.webapp.crud.movies.service;

import com.webapp.crud.movies.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMoviesService {
  
  List<Movie> getAllMovies();
  
}
