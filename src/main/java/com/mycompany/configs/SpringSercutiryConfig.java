/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.mycompany.handlers.LoginHandler;
import com.mycompany.handlers.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 *
 * @author HIEU
 */
@EnableWebSecurity
@ComponentScan(basePackages = "com.mycompany")
public class SpringSercutiryConfig extends WebSecurityConfigurerAdapter {    
    @Autowired
    private UserDetailsService userDetailsService;
//    
//    @Autowired
//    private AuthenticationSuccessHandler loginSuccessHandler; 
    
    @Autowired
    private LoginHandler loginHandler;
    
    @Autowired
    private LogoutHandler logoutHanlder;
    
//    @Autowired
//    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
//    @Bean
//    public AuthenticationSuccessHandler loginSuccessHandler() {
//        return new LoginHandler();
//    }
//    
//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() {
//        return new LogoutHandler();
//    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        
        http.formLogin().successHandler(loginHandler);
        System.out.println("run");
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        
        http.logout().logoutSuccessHandler(logoutHanlder);
        
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/garage-owner/**").hasAuthority("GARAGE_OWNER");
        

        http.csrf().disable();
    }
}
