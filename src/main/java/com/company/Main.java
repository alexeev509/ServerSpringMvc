package com.company;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Main implements WebApplicationInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.scan("com.company");

        DispatcherServlet dispatcherServlet=new DispatcherServlet(context);

        ServletRegistration.Dynamic dynamic=servletContext.addServlet("dispetcher",dispatcherServlet);
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
