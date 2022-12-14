package com.movies.moviesrecruitmentapp.app.clients.omdb;

import com.movies.moviesrecruitmentapp.app.domain.DTOs.MovieDetailsDto;
import com.movies.moviesrecruitmentapp.app.domain.DTOs.MovieDto;
import com.movies.moviesrecruitmentapp.app.domain.DTOs.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Component
public class OmdbClient {

    private final RestTemplate restTemplate;
    private final String API_ENDPOINT = "http://www.omdbapi.com/";
    private final String API_KEY = "8d1d6828"; //TODO przenieść do propertisow

    public List<MovieDto> searchForMovies(String title, String year) {

        URI url = generateSearchFilmRequestPath(title, year);

        SearchDto searchResponse = restTemplate.getForObject(url, SearchDto.class);

        if(searchResponse==null)
            return Collections.emptyList();
        return searchResponse.getFilms();
    }

    public MovieDetailsDto getMovieDetails(String imdbId) throws Exception {

        URI url = generateGetFilmDetailsRequestPath(imdbId);

        MovieDetailsDto filmDetailsResponse = restTemplate.getForObject(url, MovieDetailsDto.class);

        if(filmDetailsResponse==null)// TODO global exception handler
            throw new Exception("Get movie details returned null");
        return filmDetailsResponse;
    }

    private URI generateGetFilmDetailsRequestPath(String imdbId) {

        return UriComponentsBuilder.fromHttpUrl(API_ENDPOINT)
                .queryParam("apikey", API_KEY)
                .queryParam("i",imdbId)
                .build()
                .encode()
                .toUri();
    }

    private URI generateSearchFilmRequestPath(String title, String year){

        return UriComponentsBuilder.fromHttpUrl(API_ENDPOINT)
                .queryParam("apikey", API_KEY)
                .queryParam("type", "movie")
                .queryParam("s", title)
                .queryParam("y", year)
                .build()
                .encode()
                .toUri();
    }

}
