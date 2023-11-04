package com.example.springsecurity1;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration	
//@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}manager123").authorities("MANAGER");
		auth.inMemoryAuthentication().withUser("emp").password("{noop}emp123").authorities("EMP");
		auth.inMemoryAuthentication().withUser("SV").password("{noop}SV123").authorities("SV");
		auth.inMemoryAuthentication().withUser("SA").password("{noop}SA123").authorities("SA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/manager").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMP")
		.antMatchers("/sa").hasAuthority("SA")
		.antMatchers("/SV").hasAuthority("SV")
		.antMatchers("/commmon").hasAnyAuthority("EMP,MANAGER")
		.antMatchers("/mainapp").hasAnyAuthority("ADMIN","SV")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.and()
		.exceptionHandling()
		.accessDeniedPage("/ad");
	}

}
