package com.example.SpringDay1.seed;

import com.example.SpringDay1.persistence.api.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
// The Order ensures that this command line runner is ran first (before the ConsoleController)
@Transactional
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Seed implements CommandLineRunner{

    private final RepositoryFactory repositoryFactory;


    @Override
    public void run(String... args) throws Exception {
        repositoryFactory.createUserRepository().createUser("hey1", "hey1");
        repositoryFactory.createUserRepository().createUser("hey2", "hey2");
        repositoryFactory.createUserRepository().createUser("hey3", "hey3");
    }
}
