package main.controllers;

import main.Utils.Authenticated;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.Utils.Const;
/**
  this controller handles all exceptions/errors and displays a friendly
  error page/

 */
@Controller
public class CustomErrorController implements ErrorController {
    /**
     * forward to the general error page as get
     *
     * @return - error page
     */
    @RequestMapping("/error")
    public String handleError() {
        return Const.ERROR_PAGE;
    }

    /**
     * forward to the above mapping
     *
     * @return - mapping patch
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     *
     * @param authenticated - for use the when re-login
     * @return - client error page
     */
    @RequestMapping("/clienterror")
    public String clientHandleError(Authenticated authenticated) {
        return Const.CLIENT_ERROR_PAGE;
    }

    /**
     *
     * @param authenticated - for use the when re-login
     * @return - error page
     */
    @RequestMapping("/loginerror")
    public String loginError(Authenticated authenticated) {
        return Const.LOGIN_ERROR_PAGE;
    }
}