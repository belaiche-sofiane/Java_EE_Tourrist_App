package com.example.demo.securite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	 @Autowired
	    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());;
    	
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
     
       .authorizeRequests()
        .antMatchers("/inscription", "/SaveUser","/css/**","/js/**","/monuments","/departements","/celebrites","/lieux").permitAll()
        .antMatchers("/login").permitAll()
        
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .failureUrl("/error.html")
        .defaultSuccessUrl("/")
        .and()
        
        .logout(logout -> logout
        .logoutUrl("/logout")
        .addLogoutHandler(new SecurityContextLogoutHandler()));
       
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    	PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
    }
    
}
