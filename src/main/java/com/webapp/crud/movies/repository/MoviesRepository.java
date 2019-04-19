package com.webapp.crud.movies.repository;

import com.webapp.crud.movies.model.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity, Long> {
  
  List<MovieEntity> findAll();
}
