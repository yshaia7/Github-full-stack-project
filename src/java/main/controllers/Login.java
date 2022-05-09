package main.controllers;

import main.beans.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import main.Utils.Authenticated;
import main.Utils.Const;
import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * this controller is for handle login
 * will handle user param validate
 * user name and password
 * we cannot pass that controller if
 * we dont input the right user and password
 */
@Controller
public class Login {

    /* we get the same and only session that relevent for all the program here*/
    @Resource(name = "sessionBean")
    private Session session;

    /**
     * for validate user name
     */
    @Value("${user}")
    private String username;

    /**
     * for validate password
     */
    @Value("${password}")
    private String password;

    /**
     * The main root of the program, first root of the program
     *
     * @param authenticated - will create for each user that log in
     * @param model         - param for add/remove attribute
     * @return - next page
     */
    @GetMapping("/")
    public String main(Authenticated authenticated, Model model) {
        if (session.getIsValid())
            return "redirect:/homepage";
        return Const.REGISTER_PAGE;
    }

    /**
     * create new user and password and validate them
     *
     * @param authenticated - use for validate user and password
     * @param result        - check if input has errors
     * @param model         - param for add/remove attribute
     * @return - index page
     */
    @PostMapping("/newuser")
    public String addUser(@Valid Authenticated authenticated, BindingResult result, Model model) {

        /* validate if one of the felid is empty */
        boolean validateUser = true;
        if (result.hasErrors()) {
            validateUser = false;
        }
        /* validate user name */
        if (!authenticated.getName().equals(username) && !authenticated.getName().equals("")) {
            model.addAttribute("errorname", "worng name");
            validateUser = false;
        }
        /* validate password name */
        if (!authenticated.getPassword().equals(password) && !authenticated.getPassword().equals("")) {
            model.addAttribute("errorpassword", "wrong password");
            validateUser = false;
        }
        if (!validateUser)
            return Const.REGISTER_PAGE;
        session.setIsValid(true);
        return "redirect:/homepage";
    }
}
