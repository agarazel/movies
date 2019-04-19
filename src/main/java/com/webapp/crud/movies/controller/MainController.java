package com.webapp.crud.movies.controller;

import com.webapp.crud.movies.model.Movie;
import com.webapp.crud.movies.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MainController {
  
  @Autowired
  private IMoviesService moviesService;
  
  public MainController(IMoviesService moviesService) {
    this.moviesService = moviesService;
  }
  
  @GetMapping(path = "/start")
  public String getIndex() {
    return "Start here";
  }
  
  @GetMapping(path = "/movies")
  public List<Movie> getMoviesList() {
    return moviesService.getAllMovies();
  }
  
}
