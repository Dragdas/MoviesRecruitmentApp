package com.movies.moviesrecruitmentapp.app.initialization;

import com.movies.moviesrecruitmentapp.app.domain.FavouriteMovie;
import com.movies.moviesrecruitmentapp.app.domain.User;
import com.movies.moviesrecruitmentapp.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersInserter {

    private final static List<User> initialUsers= List.of(
            new User(null,"bartek", "password", new ArrayList<FavouriteMovie>()),
            new User(null,"zuza", "abcd", new ArrayList<FavouriteMovie>()),
            new User(null, "ania", "psw123", new ArrayList<FavouriteMovie>())
    );

    private final UserRepository userRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        userRepository.saveAll(initialUsers);
    }

}
