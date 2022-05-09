package main;

import main.beans.Session;
import main.filter.LoggingInterceptor;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
  this is a class for configuring SringMVC
  here we register our interceptor class
  we add the url that we want to listen
  and block in the filter
 */
@EnableWebMvc
@ComponentScan(basePackages = {"main"})
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /** we get the same and only session that relevent for all the program here*/
    @Resource(name = "sessionBean")
    private Session session;

    /**
     * @param registry - register the web root
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor(session)).addPathPatterns("/adduser",
                "/index", "/register", "/homepage", "/deletehistory", "/getallusers");
    }

    /**
     *
     * @param registry - add the static files to project
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}