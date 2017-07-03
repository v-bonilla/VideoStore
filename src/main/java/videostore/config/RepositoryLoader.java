package videostore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import videostore.model.Movie;
import videostore.model.User;
import videostore.repository.MovieRepository;
import videostore.repository.UserRepository;
import videostore.service.TMDBRestService;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by victor on 9/06/17.
 */
@Component
public class RepositoryLoader {

    @Autowired
    private UserRepository repositoryOfUsers;

    @Autowired
    private MovieRepository repositoryOfMovies;

    @Autowired
    private TMDBRestService tmdbRestService;

    @PostConstruct
    private void initRepository(){
        // Admin user
        GrantedAuthority[] roles = { new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN") };
        User user = new User("a",new BCryptPasswordEncoder().encode("a"),"admin@videostore.com", Arrays.asList(roles));
        repositoryOfUsers.save(user);

        // Movies
        Movie movie1 = new Movie("Interstellar",
                "https://www.youtube.com/watch?v=UoSSbmD9vqc",
                "",
                -1,
                "",
                "",
                "",
                0.0);
        repositoryOfMovies.save(tmdbRestService.getMovieInfo(movie1));
        Movie movie2 = new Movie("Deadpool",
                "https://www.youtube.com/watch?v=7evoYlgMmoY",
                "",
                -1,
                "",
                "",
                "",
                0.0);
        repositoryOfMovies.save(tmdbRestService.getMovieInfo(movie2));
        Movie movie3 = new Movie("Regreso al futuro II",
                "https://www.youtube.com/watch?v=Bmr2fgaoSxs",
                "",
                -1,
                "",
                "",
                "",
                0.0);
        repositoryOfMovies.save(tmdbRestService.getMovieInfo(movie3));
    }

}