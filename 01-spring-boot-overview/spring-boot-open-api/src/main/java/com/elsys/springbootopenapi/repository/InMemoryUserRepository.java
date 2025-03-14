package com.elsys.springbootopenapi.repository;

import com.elsys.springbootopenapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final List<User> users;
    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
        this.users.add(new User(0, "John Doe"));
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public Optional<User> updateUser(int id, String newName){
        Optional<User> findUser =  users.stream()
                .filter(user -> user.getId()==id)
                .findFirst();
        findUser.ifPresent(user -> user.setName(newName));
        return findUser;
    }

    public boolean deleteUser(int id){
        return users.removeIf(user -> user.getId() == id);
    }
}
