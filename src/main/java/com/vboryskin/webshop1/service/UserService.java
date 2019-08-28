package com.vboryskin.webshop1.service;

import com.vboryskin.webshop1.dto.UserDTO;
import com.vboryskin.webshop1.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findOne(Long id);
    Optional<User> findOne(String username);
    void delete(Long id);
    void delete(String username);
    List<User> findAll();
    void registerNewUser(UserDTO userDTO);
}
