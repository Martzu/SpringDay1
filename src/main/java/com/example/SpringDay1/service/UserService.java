package com.example.SpringDay1.service;

import com.example.SpringDay1.entity.User;
import com.example.SpringDay1.persistence.api.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final RepositoryFactory repositoryFactory;

    public Optional<User> findById(int id)
    {
        return repositoryFactory.createUserRepository().findById(id);
    }

    public Optional<User> findByUsername(String username)
    {
        return repositoryFactory.createUserRepository().findByUsername(username);
    }

    public void createUser(String user, String password)
    {
        repositoryFactory.createUserRepository().createUser(user, password);
    }
}
