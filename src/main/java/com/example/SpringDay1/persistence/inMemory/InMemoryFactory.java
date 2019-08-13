package com.example.SpringDay1.persistence.inMemory;

import com.example.SpringDay1.persistence.api.RepositoryFactory;
import com.example.SpringDay1.persistence.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name="repository-type", havingValue = "MEMORY")
public class InMemoryFactory implements RepositoryFactory {

    private final UserRepository userRepository = new InMemoryUserRepository();

    @Override
    public UserRepository createUserRepository() {
        return userRepository;
    }


}
