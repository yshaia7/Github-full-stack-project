package main.Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * that class is for convert information
 * that we get form github, he takes json
 * and convert the param and store them into
 * string for we can use them later
 *
 * input - json
 * output - 3 param that converted from the json
 * login user name
 * Website address of the user name
 * Number of user followers
 */
public final class ParseUserInfo {
    /**
     * param for store the json info
     */
    private static String name;
    private static String web;
    private static String followers;

    /**
     * @return user name
     */
    public static String getName() {
        return name;
    }

    /**
     * @return user website address
     */
    public static String getWeb() {
        return web;
    }

    /**
     * @return number of user followers
     */
    public static String getFollowers() {
        if(followers.equals("0"))
            return name + " have no followers";
        return name + " have " + followers + " followers";
    }

    /**
     * here it parse the information , convert the
     * json object into 3 diff string, we will store
     * them into the 3 param that define above
     *
     * @param json - json that contain the 3 param above
     */
    public static void parseData(String json) {
        try {
            JSONObject obj = new JSONObject(json);

            name = obj.getString("login");
            web = obj.getString("html_url");
            followers = obj.getString("followers");

            //if (followers.equals("0"))
               // followers = name + " have no followers";

        } catch (JSONException e) {

        }
    }

}
