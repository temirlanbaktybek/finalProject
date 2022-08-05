package com.example.project666.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;


    @Autowired
    DataSource ds;


    private static final String ADMIN_ENDPOINT = "/admin/**";
    private static final String JOBSEEKER_ENDPOINT = "/jobseeker/**";
    private static final String HEADHUNTER_ENDPOINT = "/headhunter/**";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(ds)
//                .usersByUsernameQuery("select jobseeker_login, jobseeker_password from jobseeker where jobseeker_login=?")
//                .authoritiesByUsernameQuery("select jobseeker_login, roles from jobseeker where username=?");
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(JOBSEEKER_ENDPOINT).hasAnyRole("USER", "ADMIN")
                .antMatchers(ADMIN_ENDPOINT).hasAnyRole("ADMIN")
                .antMatchers(HEADHUNTER_ENDPOINT).hasAnyRole("HEADHUNTER", "ADMIN")
                .anyRequest().authenticated().and().httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .rememberMe().tokenValiditySeconds(3500).key("mySecret!")
                .and()
                .formLogin()
                .failureHandler(authenticationFailureHandler())
                .and()
                .cors()
                .and()
                .headers()
                .xssProtection()
                .and()
                .contentSecurityPolicy("script-src 'self'");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }


}