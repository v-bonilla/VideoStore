package videostore.service;

import videostore.model.User;

/**
 * Created by victor on 17/06/17.
 */
public interface UserService {

    String login ();

    User getUser (Integer userId);

    User newUser (User user);

    User modifyUser (User user);

    User deleteUser (Integer userId);

}