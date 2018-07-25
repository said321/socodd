//package com.socodd.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	    @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication()
//	          .withUser("admin").password("admin").roles("ADMIN","USER");
//	        auth.inMemoryAuthentication()
//	          .withUser("user1").password("user1").roles("USER");
//	        System.out.println("config1");
//	    }
//	 
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
////	        http
////	          .authorizeRequests()
////	          .antMatchers("/login*").anonymous()
////	          .anyRequest().authenticated()
////	          .and()
////	          .formLogin()
////	          .loginPage("/login")
////	          .defaultSuccessUrl("/home")
////	          .failureUrl("/login")
////	          .and()
////	          .logout().logoutSuccessUrl("/login");
//	    	http.formLogin().loginPage("/login");
//	    	http.authorizeRequests().antMatchers("/home").hasRole("ADMIN");
//	    	System.out.println("config2");
//	    }
//	      
//}
