package com.GraphiFlow.project_PSC.config;

import com.GraphiFlow.project_PSC.entities.User;
import com.GraphiFlow.project_PSC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Pedro", 43, 'M', "pedro098@gmail.com", "111.111.111.12", "Senha");
        User u2 = new User(null, "João", 23, 'M', "joão098@gmail.com", "111.111.111.13", "Senha");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
