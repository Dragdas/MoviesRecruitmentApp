package com.movies.moviesrecruitmentapp.app.repository;

import com.movies.moviesrecruitmentapp.app.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u left join fetch u.favouriteMovies")
    List<User> findAll();

}
