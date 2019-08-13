package com.example.SpringDay1.persistence.api;

import com.example.SpringDay1.entity.User;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findById(int id);

    public Optional<User> findByUsername(String username);

    public void createUser(String user, String password);
}
