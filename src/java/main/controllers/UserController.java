package main.controllers;

import javax.validation.Valid;

import main.Utils.ParseUserInfo;
import main.repo.User;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import main.Utils.Const;

import java.util.List;

/**
 * user controller, we will use it for create and add new
 * user to the data base, we also can delete all users
 * and get all the users in the data base.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    /**
     * @return - return user repository
     */
    private UserRepository getRepo() {
        return repository;
    }

    /**
     * @param user   - the user that create
     * @param result -for validate the input
     *
     * @return - homepage
     */
    @GetMapping("/adduser")
    public String onRealod(@Valid User user, BindingResult result) {
        return "redirect:/homepage";
    }
    /**
     * create new user and store it into data base
     *
     * @param user   - the user that create
     * @param result -for validate the input
     * @param model  - add/set attribute
     * @return - homepage
     */
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        /* validate input */
        if (result.hasErrors()) {
            return Const.HOME_PAGE;
        }

        synchronized ( getRepo()){
            User usr = getRepo().findByName(user.getName());

            /* if user not found in the data base add them to the data base */
            if (usr == null) {
                user.setWeb(ParseUserInfo.getWeb());
                user.setCount(1);
                getRepo().save(user);

            }
            /* user already exist need to increase the counter of them*/
            else {
                usr.setCount(usr.getCount() + 1);

            }
        }

        /* store number of followers for show it after user create */
        model.addAttribute("followers", ParseUserInfo.getFollowers());

        return "forward:/homepage";
    }

    /**
     * delete all users n the data base
     *
     * @param user  - for handle user
     * @return - next page
     */
    @RequestMapping("/deletehistory")
    public String deleteUser(User user) {
        getRepo().deleteAll();
        return Const.HOME_PAGE;
    }

    /**
     * get all users in the data base as json
     *
     * @return - sorted list of 10 user in the data base
     */
    @RequestMapping(value = "/getallusers")
    public @ResponseBody
    List<User> getAll() {
        return getRepo().findFirst10ByOrderByCountDesc();

    }
}


