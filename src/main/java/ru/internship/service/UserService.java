package ru.internship.service;

import org.springframework.stereotype.Service;
import ru.internship.form.UserCredentials;
import ru.internship.model.User;
import ru.internship.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByLoginAndPassword(String login, String password) {
        return login == null || password == null ? null : userRepository.findByLoginAndPassword(login, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public boolean isLoginFree(String login) {
        return userRepository.countByLogin(login) == 0;
    }

    public User register(UserCredentials userCredentials) {
        User user = new User();
        user.setLogin(userCredentials.getLogin());
        userRepository.save(user);
        userRepository.updatePassword(user.getId(), userCredentials.getLogin(), userCredentials.getPassword());
        return user;
    }
}
