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

    @PostConstruct
    private void initRepository(){
        // Admin user
        GrantedAuthority[] roles = { new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN") };
        User user = new User("a",new BCryptPasswordEncoder().encode("a"),"admin@videostore.com", Arrays.asList(roles));
        repositoryOfUsers.save(user);

        // Movies
        Movie movie1 = new Movie("Star Wars VII: El despertar de la fuerza",
                "https://www.youtube.com/watch?v=FHbnQ5DUUF4",
                "Descripcion de Star Wars VII",
                2015,
                "J. J. Abrams",
                "Daisy Ridler, John Boyega",
                "http",
                6.9);
        repositoryOfMovies.save(movie1);
    }

}