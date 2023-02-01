package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<User> getUsersList() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
