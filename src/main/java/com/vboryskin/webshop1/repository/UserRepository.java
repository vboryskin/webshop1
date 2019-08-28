package com.vboryskin.webshop1.repository;

import com.vboryskin.webshop1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findUserByUsername(String username);
    void deleteUserByUsername(String username);
    boolean existsUserByUsernameOrEmail(String username, String email);
}
