package com.hashes.users.service;

import com.hashes.users.entity.User;
import com.hashes.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getById(String id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User update(String id, User user) {

        return userRepository.save(user);
    }
}
