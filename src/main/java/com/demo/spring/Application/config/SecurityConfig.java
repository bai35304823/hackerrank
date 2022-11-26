package com.demo.spring.Application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.csrf().disable(); //Close CSRF verification
		http.formLogin().defaultSuccessUrl("/getAll");
		 return http.build();
		/*
		 * http.csrf().disable(); //Close CSRF verification
		 * http.authorizeRequests().anyRequest().authenticated(); //Intercept all
		 * interfaces http. formLogin() // .loginPage("/login") //Custom Login page //
		 * .usernameParameter("myUsername") //Custom username parameter name //
		 * .passwordParameter("myPassword") //Custom password parameter name //
		 * .loginProcessingUrl("/doLogin") //The transfer address after the defined form
		 * is submitted .defaultSuccessUrl("/success") //Address to jump after
		 * successful verification // .failureUrl("/failure") //The address of the
		 * verification failure jump .permitAll(); //Interfaces related to form login
		 * are not intercepted
		 * 
		 */    }
}

