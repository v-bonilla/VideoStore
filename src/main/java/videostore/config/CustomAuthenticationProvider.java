package videostore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import videostore.model.User;
import videostore.repository.UserRepository;

import java.util.List;

/**
 * Created by victor on 9/06/17.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String user_name = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userRepository.findByUserName(user_name);

        if (user == null) {
            throw new BadCredentialsException("User not found");
        }

        if (!new BCryptPasswordEncoder().matches(password, user.getUser_password())) {
            throw new BadCredentialsException("Wrong password");
        }

        List<GrantedAuthority> roles = user.getRoles();
        return new UsernamePasswordAuthenticationToken(user_name, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
