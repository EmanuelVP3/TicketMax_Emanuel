package app.repository.mappers;

import app.domain.User;
import app.service.outputPorts.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplCollection implements UserRepository {

    List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        if (user.getId() == null || selectById(user.getId()) != null) {
            return null;
        }
        users.add(user);

        /*
        users.add(String.valueOf(user.getId()));
        users.add(user.getName());
        users.add(user.getLastName());
        users.add(user.getEmail());
        users.add(user.getPhone());
        users.add(user.getPassword());
        users.add(String.valueOf(user.isState()));
        users.add(user.getCity());
        users.add(user.getPreferences());*/

        return user;
    }

    @Override
    public User selectById(int id) {
        for (User user : users) {
            if (user.getId() != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> selectAll() {

        return users;
    }

    @Override
    public User updateUser(User user) {
        for (int index = 0; index < users.size(); index++) {
            User currentUser = users.get(index);
            if (currentUser.getId() != null && currentUser.getId().equals(user.getId())) {
                users.set(index, user);
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() != null && user.getId() == id);
    }

    @Override
    public User create(User user) {
        return save(user);
    }

    @Override
    public int countUsers() {
        return users.size();
    }
}
