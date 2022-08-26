package com.movies.moviesrecruitmentapp.app.repository;

import com.movies.moviesrecruitmentapp.app.domain.FavouriteMovie;
import org.springframework.data.repository.CrudRepository;

public interface FavouriteMovieRepository extends CrudRepository<FavouriteMovie, Long> {
}
