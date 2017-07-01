package videostore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import videostore.model.User;
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

    @PostConstruct
    private void initRepository(){
        GrantedAuthority[] roles = { new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN") };
        User user = new User(0,"admin",new BCryptPasswordEncoder().encode("admin"),"admin@videostore.com", Arrays.asList(roles));
        repositoryOfUsers.save(user);
    }

}