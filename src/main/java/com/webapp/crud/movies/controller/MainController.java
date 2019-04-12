package com.webapp.crud.movies.controller;

import com.webapp.crud.movies.model.Movie;
import com.webapp.crud.movies.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
  
  public MainController(IMoviesService moviesService) {
    this.moviesService = moviesService;
  }
  
  @Autowired
  private IMoviesService moviesService;
  
  @GetMapping(path = "/movies")
  public List<Movie> getMovieList() {
    return moviesService.getAllMovies();
  }
  
}
