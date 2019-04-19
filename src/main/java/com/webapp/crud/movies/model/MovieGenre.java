package com.webapp.crud.movies.model;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE_GENRE")
public enum MovieGenre {
  
  ACTION("ACTION"),
  ADVENTURE("ADVENTURE"),
  THRILLER("THRILLER"),
  FILM_NOIR("FILM_NOIR"),
  FANTASY("FANTASY"),
  SCIENCE_FICTION("SCIENCE_FICTION"),
  WESTERN("WESTERN"),
  COMEDY("COMEDY"),
  HISTORY("HISTORY"),
  DRAMA("DRAMA"),
  ROMANCE("ROMANCE"),
  BIOPIC("BIOPIC");
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GENRE_ID", nullable = false)
  private Long id;
  
  private String genre;
  
  MovieGenre(String genre) {
    this.genre = genre;
  }
  
  public Long getId() {
    return id;
  }
  
  public String getGenre() {
    return genre;
  }
}




