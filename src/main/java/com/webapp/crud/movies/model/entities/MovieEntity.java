package com.webapp.crud.movies.model.entities;

import com.webapp.crud.movies.model.MovieGenre;

import javax.persistence.*;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

//import org.hibernate.mapping.Map;

@Entity
@Table(name = "MOVIE")
public class MovieEntity {
  
  @Embeddable
  public static enum Genre {
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
    
    private String genreType;
    
//    Genre() {}
  
    Genre(String genreType) {
      this.genreType = genreType;
    }
  
    public String getGenreType() {
      return genreType;
    }
  }
  
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;
  
  private String name;
  
  private String director;
  
  private String writer;
  
  private String producer;
  
//  @Enumerated(EnumType.STRING)
//  @ElementCollection(targetClass = MovieGenre.class, fetch = FetchType.EAGER)
////  @ElementCollection
////  @CollectionTable(name = "MOVIE_GENRES", joinColumns = @JoinColumn(name = "MOVIE_ID"))
////  @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "ID"))
//  @JoinTable(name = "MOVIE_GENRE", joinColumns = @JoinColumn(name = "MOVIE_GENRE.ID"))
//  @JoinTable
//  @Formula("SELECT * FROM movie_genre WHERE movie_genre.id = ID")
//  @Column(name = "GENRES")
//  private Set<MovieGenre> genres = new HashSet<>();

//  @ElementCollection
//  @CollectionTable(name = "MOVIE_GENRE", joinColumns = @JoinColumn(name = "GENRE"))
//  @Column(name = "GENRE")

//  @MapKey
//  private Set<MovieGenre> genres = new HashSet<>();
  
  @ElementCollection
  @CollectionTable(name = "MOVIE_GENRE")
  @MapKeyColumn(name = "GENRE_ID")
  @Column(name = "GENRE")
  @OneToMany(targetEntity = MovieGenre.class)
  private Map<Long, String> genres;
  
  private Integer releaseDate;
  
  public MovieEntity() {
  }
  
//  public MovieEntity(Long id, Set<MovieGenre> genres) {
//    this.id = id;
//    this.genres = genres;
//  }
  
  
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
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
  
//  @ElementCollection(targetClass = MovieGenre.class, fetch = FetchType.EAGER)
//  @ElementCollection
//  @CollectionTable(name = "MOVIE_GENRES", joinColumns = @JoinColumn(name = "MOVIE_ID"))
//  @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "ID"))
//  @JoinTable(name = "MOVIE_GENRE", joinColumns = @JoinColumn(name = "MOVIE_GENRE.ID"))

//  public Set<MovieGenre> getGenres() {
//    return genres;
//  }
//
//  public void setGenres(Set<MovieGenre> genres) {
//    this.genres = genres;
//  }
  
  
  public Map<Long, String> getGenres() {
    return genres;
  }
  
  public void setGenres(Map<Long, String> genres) {
    this.genres = genres;
  }
  
  public Integer getReleaseDate() {
    return releaseDate;
  }
  
  public void setReleaseDate(Integer releaseDate) {
    this.releaseDate = releaseDate;
  }
}
