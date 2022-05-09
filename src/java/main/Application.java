package main;

import main.beans.Session;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.springframework.web.context.WebApplicationContext;

/**
 * this is the main of the project
 * here the session will be create and make them
 * store in the data base
 */
@SpringBootApplication
public class Application {

    @Autowired
    public UserRepository userRepository;

    /**
     * @param args - args for application
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     *
     * @return - bean session that use spring technology
     */
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session sessionBean() {
        return new Session();
    }

}
