package videostore.service;

import videostore.model.User;

import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
public interface UserService {

    List<User> getUsers ();

    void newUser (User user);

    void modifyUser (User user);

    void deleteUser (Integer userId);

}