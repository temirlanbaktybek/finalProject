package com.example.project666.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
class ConfigOfDishpatcherandRequestContextListner {
    @Bean
    DispatcherServlet dispatcherServlet() {
        DispatcherServlet srvl = new DispatcherServlet();
        srvl.setThreadContextInheritable(true);
        return srvl;
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}