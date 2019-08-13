package com.example.SpringDay1.controller;

import com.example.SpringDay1.persistence.api.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
@RequiredArgsConstructor
public class Controller implements CommandLineRunner {

    private final RepositoryFactory repositoryFactory;
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String password = scanner.nextLine();
        if(repositoryFactory.createUserRepository().findByUsername(user).isPresent() && repositoryFactory.createUserRepository().findByUsername(user).get().getPassword().equals(password))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NOPE");
        }
    }
}
