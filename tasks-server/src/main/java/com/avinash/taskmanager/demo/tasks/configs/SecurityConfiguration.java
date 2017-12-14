/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.configs;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/** 
 * 
 * @author Avinash
 *
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/swagger-ui.html**", "/swagger-ui.html/**", "/swagger-resources/**", "/webjars/**", "/v2/**");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {	
		httpSecurity.csrf().disable();
	}
}
