package videostore.repository;

import org.springframework.data.repository.CrudRepository;
import videostore.model.User;

/**
 * Created by victor on 9/06/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}