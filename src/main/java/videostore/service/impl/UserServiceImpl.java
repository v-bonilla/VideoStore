package videostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import videostore.model.User;
import videostore.repository.UserRepository;
import videostore.service.UserService;

import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    // Get a list with all users in the repository
    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    // Save a new user in the repository
    @Override
    public void newUser(User user) {
        repository.save(user);
    }

    // Save a modified user in the repository
    // If there are empty fields in the user info, it set the old fields
    @Override
    public void modifyUser(User user) {
        User actualUser = repository.findByUserId(user.getUserId());
        if (actualUser!= null){
            if (user.getUserName().equals("")){
                user.setUserName(actualUser.getUserName());
            }
            if (user.getUserEmail().equals("")){
                user.setUserEmail(actualUser.getUserEmail());
            }
            if (user.getUserPassword().equals("")){
                user.setUserPassword(actualUser.getUserPassword());
            } else {
                user.setUserPassword(new BCryptPasswordEncoder().encode(user.getUserPassword()));
            }
            repository.save(user);
        }
    }

    // Delete a user
    @Override
    public void deleteUser(Integer userId) {
        User actualUser = repository.findByUserId(userId);
        if (actualUser != null){
            repository.delete(actualUser);
        }
    }

}