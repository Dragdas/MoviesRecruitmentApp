package com.movies.moviesrecruitmentapp.app.controller;


import com.movies.moviesrecruitmentapp.app.domain.FavouriteMovie;
import com.movies.moviesrecruitmentapp.app.domain.User;
import com.movies.moviesrecruitmentapp.app.repository.FavouriteMovieRepository;
import com.movies.moviesrecruitmentapp.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO usunąć kontrollery

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@CrossOrigin("*")//todo usunąć
public class UserController {

    private final UserRepository userRepository;
    private final FavouriteMovieRepository favouriteMovieRepository;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {


        repoTest();


        return ResponseEntity.ok( userRepository.findAll() );
    }

    @Transactional
    public void repoTest() {
        User user = userRepository.findById(2L).get();
        FavouriteMovie fv = new FavouriteMovie(1L,"tt0325980");
        favouriteMovieRepository.save(fv);

        user.getFavouriteMovies().add(fv);
        userRepository.save(user);
    }


}
