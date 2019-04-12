package com.webapp.crud.movies.model;

import java.time.LocalDateTime;

public class Movie {
  
  private String name;
  private String director;
  private String writer;
  private String producer;
  private MovieGenre genre;
  private LocalDateTime releaseDate;
  
  public Movie(String name, MovieGenre genre) {
    this.name = name;
    this.genre = genre;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDirector() {
    return director;
  }
  
  public void setDirector(String director) {
    this.director = director;
  }
  
  public String getWriter() {
    return writer;
  }
  
  public void setWriter(String writer) {
    this.writer = writer;
  }
  
  public String getProducer() {
    return producer;
  }
  
  public void setProducer(String producer) {
    this.producer = producer;
  }
  
  public MovieGenre getGenre() {
    return genre;
  }
  
  public void setGenre(MovieGenre genre) {
    this.genre = genre;
  }
  
  public LocalDateTime getReleaseDate() {
    return releaseDate;
  }
  
  public void setReleaseDate(LocalDateTime releaseDate) {
    this.releaseDate = releaseDate;
  }
}
