package videostore.service;

/**
 * Created by victor on 17/06/17.
 */
public interface UserService {

    String login ();

    String newUser (String user_name, String user_password, String user_email);

    String modifyUser (int user_id, String user_name, String user_password, String user_email);

    String deleteUser (int user_id);

}
