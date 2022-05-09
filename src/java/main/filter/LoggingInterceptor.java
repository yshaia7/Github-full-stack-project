package main.filter;

import main.beans.Session;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this class intercepts all callases for validate if the user already
 * log in, if not it will forward to the error page that said u need
 * to log in first. validate if the user loged in be using the session
 * boolean
 */
public class LoggingInterceptor implements HandlerInterceptor {
    private Session session;

    /**
     *
     * @param session - store the private session for validate
     */
    public LoggingInterceptor(Session session) {
        this.session = session;
    }

    /**
     *
     * @param request - from client
     * @param response - to the client
     * @param handler - object to handle
     * @return - error page or continue to the next page/controller that relevent
     * @throws Exception - general exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (!session.getIsValid())
            response.sendRedirect("/loginerror");

        return true; // continue with the request to next page/controller
    }
}