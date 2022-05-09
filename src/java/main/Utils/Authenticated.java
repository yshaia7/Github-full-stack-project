package main.Utils;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * that class will created for each user that login
 * into the web, we also validate input here
 */
@Component
public class Authenticated {
    /**store the user login name*/
    @NotBlank(message = "Name is mandatory")
    private String name;

    /**store the user password*/
    @NotBlank(message = "Password is mandatory")
    private String password;

    public Authenticated() {
    }

    /**
     * @param name     - user name to store when user create
     * @param password - password to store when user create
     */
    public Authenticated(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * @param name - set user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return - user name
     */
    public String getName() {
        return name;
    }

    /**
     * @return - get user name
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password - set user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
