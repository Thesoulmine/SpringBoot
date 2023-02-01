package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsersList();

    void deleteUser(User user);

    Optional<User> getUser(long id);

    @Transactional
    void saveUser(User user);
}
