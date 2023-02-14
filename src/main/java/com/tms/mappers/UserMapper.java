package com.tms.mappers;

import com.tms.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setAge(rs.getInt("age"));
        user.setLogin(rs.getString("user_login"));
        user.setPassword(rs.getString("user_password"));
        return user;
    }
}
