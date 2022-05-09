package main.controllers;

import main.Utils.Authenticated;
import main.beans.Session;
import main.repo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.Utils.Const;
import javax.annotation.Resource;

/**
 * This controller is for browsing between pages
 * every time when we change pages we will
 * use that controller
 */

@Controller
public class BrowsingController {

    /**
     *  we get the same and only
     *  session that relevent for all
     *  the program here*/
    @Resource(name = "sessionBean")
    private Session session;

    /**
     * forward to home page
     *
     * @param user - store user detailes
     * @return - index or error page depend if there is error
     */
    @RequestMapping("/homepage")
    public String index(User user) {
        if (session.getIsValid())
            return Const.HOME_PAGE;
        else
            return Const.ERROR_PAGE;
    }

    /**
     * forward to register page with get request
     *
     * @param authenticated for remove user name and password
     * @return - register page
     */
    @RequestMapping("/logout")
    public String logOut(Authenticated authenticated) {
        /* if user logout we block all other urls*/
        //session.setIsValid(false);
        return Const.REGISTER_PAGE;
    }
}
