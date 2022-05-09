package main.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * class that manage all the connection with githube
 * here we open connection and handle all exception can
 * cause during that connection
 */
public class GitHubConnection {
    private static String gitHubPath = "https://api.github.com/users/";

    public GitHubConnection() {
    }

    /**
     * we get user login name and create link to github website
     * then we connect to the website and get json
     * we forward the json to ParseUserInfo for pars the info
     *
     * @param userToSearch - login user name to search
     */
    public void fetchNewUser(String userToSearch) {
        URL url = null;
        BufferedReader bufferedReader = null;
        StringBuilder content = new StringBuilder();
        try {
            url = new URL(gitHubPath + userToSearch);

            URLConnection urlConnection = url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;

            /* read all user info from github */
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }

        } catch (MalformedURLException | NullPointerException | FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
        /* forward the json we want to pars*/
        ParseUserInfo.parseData(content.toString());
    }
}
