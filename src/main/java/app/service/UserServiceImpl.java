package app.service;

import app.domain.User;
import app.service.inputPorts.UserService;
import app.service.outputPorts.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences) {

        User user = new User(id, name, lastName, email, phone, password, state, city, preferences);

        return userRepository.save(user);
    }

    @Override
    public void selectById(int id) {

    }

    @Override
    public void update() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public List<User> selectUsers() {

        return userRepository.selectAll();
    }

}
