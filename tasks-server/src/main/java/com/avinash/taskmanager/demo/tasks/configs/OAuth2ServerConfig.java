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
public class OAuth2ServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.antMatcher("/**")
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.antMatchers("/swagger-ui.html**", "/swagger-ui.html/**", "/swagger-resources/**", "/webjars/**", "/v2/**").permitAll();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}
}
