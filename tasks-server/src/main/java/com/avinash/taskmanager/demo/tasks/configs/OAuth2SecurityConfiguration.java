/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Avinash
 *
 */
@Configuration
@EnableResourceServer
public class OAuth2SecurityConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.antMatcher("/api/**")
		.authorizeRequests()
		.antMatchers("/swagger-ui.html**", "/swagger-ui.html/**", "/swagger-resources/**", "/webjars/**", "/v2/**").permitAll()
		.anyRequest()
		.authenticated();
		
		httpSecurity.csrf().disable();
	}
}
