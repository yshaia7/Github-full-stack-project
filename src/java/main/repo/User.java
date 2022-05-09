package main.repo;

import main.Utils.GitHubConnection;
import main.Utils.ParseUserInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * entity class for each user that created and stored
 * in the data base, in the class we fetch the login name
 * of the user .
 * we also validate the input and check if the user exist
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * bellow param for store info that fetch from githube
     */
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String web;
    private int count;

    /**
     * update user githube page link
     *
     * @param web - save user githube link page
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @param id - set user id of the data base id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return - get user link website
     */
    public String getWeb() {
        return web;
    }

    /**
     * @return user login name
     */
    public String getName() {
        return name;
    }

    /**
     * @return user id
     */
    public long getId() {
        return id;
    }

    /**
     * here we set the user login name, we fetch the login from github
     *
     * @param name set name as login name that fetch from githube
     */
    public void setName(String name) {
        /* if the input is blank we dont get in */
        if (name != "") {
            GitHubConnection gitHubConnection = new GitHubConnection();
            gitHubConnection.fetchNewUser(name);
            name = ParseUserInfo.getName();
            this.name = name;
        }

    }

    /**
     * @return - number of time user been searched
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count - update number of time that user been searched
     */
    public void setCount(int count) {
        this.count = count;
    }
}

