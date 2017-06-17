package videostore.service.impl;

import org.springframework.stereotype.Service;
import videostore.service.UserService;

/**
 * Created by victor on 17/06/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login() {
        return null;
    }

    @Override
    public String newUser(String user_name, String user_password, String user_email) {
        return null;
    }

    @Override
    public String modifyUser(int user_id, String user_name, String user_password, String user_email) {
        return null;
    }

    @Override
    public String deleteUser(int user_id) {
        return null;
    }

}
