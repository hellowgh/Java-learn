package com.example.registrationlogindemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RegistrationLoginDemoApplication implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    public RegistrationLoginDemoApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistrationLoginDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.passwordEncoder.encode("wgh.000"));
    }
}
