package com.tms.service;

import com.tms.domain.User;
import com.tms.exception.UserNotFoundException;
import com.tms.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service
public class UserService {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserById(int id) throws UserNotFoundException {
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", new UserMapper(), new Object[]{id});
        if (user.getId() == 0) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) jdbcTemplate.query("SELECT * FROM users",new UserMapper());
    }


    public int createUser(User user) {
        return jdbcTemplate.update("INSERT INTO users (id, first_name, last_name, age, user_login, user_password) VALUES (DEFAULT, ?, ?, ?, ?, ?)",
                new Object[]{user.getFirstName(),user.getLastName(),user.getAge(),user.getLogin(),user.getPassword()});
    }

    public int updateUserById(int id, String firstName, String lastName, int age, String login, String password) {
        return jdbcTemplate.update("UPDATE users SET first_name=?, last_name=?, age=?, user_login=?, user_password=? WHERE id=?",
                new Object[]{firstName,lastName,age,login,password,id});
    }

    public int deleteUserById(int id) {
       return jdbcTemplate.update("DELETE FROM users WHERE id=?", new Object[]{id});
    }
}
