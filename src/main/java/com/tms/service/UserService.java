package com.tms.service;

import com.tms.domain.User;
import com.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User getUserByAge(int age) {
        return userRepository.findUserByAge(age);
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserById(User user) {
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public String getRole(Integer id){
        return userRepository.getRole(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveUserTransactional(User user) {
        userRepository.save(user);
    }
}