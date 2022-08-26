package com.movies.moviesrecruitmentapp.app.domain;


import com.movies.moviesrecruitmentapp.app.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "favourite_movies")
public class FavouriteMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "imdb_id", nullable = false)
    private String imdbId;

}
