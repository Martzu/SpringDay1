package com.example.SpringDay1.persistence.inMemory;

import com.example.SpringDay1.entity.User;
import com.example.SpringDay1.persistence.api.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class InMemoryUserRepository implements UserRepository {

    private final Map<Integer, User> data = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        for(User user : data.values())
        {
            if(user.getUsername().equals(username))
            {
                return Optional.ofNullable(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void createUser(String user, String password) {
        data.put(data.size(), new User(data.size(), user, password));
    }
}
