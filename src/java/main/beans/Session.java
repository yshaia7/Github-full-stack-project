package main.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this is the session bean class, for each user we will
 * creat one session class, we will use that class for
 * validate the login with the user name and password
 */
@Component
public class Session implements Serializable {
    private static final long serialVersionUID = 5289198604308413723L;

    private Boolean isValid = false;
    private ArrayList<String> session;

    /**
     * initilaze session
     */
    public Session() {
        this.session = new ArrayList<>();
    }

    /**
     * @return return the current session
     */
    public ArrayList<String> getSession() {
        return session;
    }

    /**
     * @return the boolean that said if the user already sign in
     */
    public Boolean getIsValid() {
        return isValid;
    }

    /**
     * @param isValid - set boolean that said user sign in/logout
     */
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * @param session set the session, usely use it when the session create
     */
    public void setSession(ArrayList<String> session) {
        this.session = session;
    }

    /**
     * @param s - add new session to the arr session that exist
     */
    public void add(String s) {
        session.add(s);
    }


}