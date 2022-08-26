package com.movies.moviesrecruitmentapp.app.clients.omdb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OmdbClientTest {

    @Autowired
    OmdbClient omdbClient;

    @Test
    void movieSearchTest(){

        omdbClient.searchForMovies("pirates","").forEach(System.out::println);

    }

    @Test
    void getMovieDetails(){
        try {
            System.out.println(omdbClient.getMovieDetails("tt5126922"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}