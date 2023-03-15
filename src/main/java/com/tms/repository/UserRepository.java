package com.tms.repository;

import com.tms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.age=:age")
    User findUserByAge(int age);

    User findUserByLogin(String login);

    @Query(nativeQuery = true, value = "SELECT role FROM roles WHERE user_id=:id")
    String getRole(int id);
}