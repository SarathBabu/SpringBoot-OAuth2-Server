package com.oauth2.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("userone").password("{noop}password").roles("USER")
				.authorities("ROLE_USER");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/webjars/**", "/static/**", "/css/**", "/loginFailure").permitAll().and()
				.authorizeRequests().antMatchers("/login", "/loginPost").permitAll().anyRequest().authenticated().and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/homepage")
				.failureUrl("/login?error=true")
				.permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}

	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
		return new MyAuthenticationSuccessHandler();
	}

	@Bean
	public AuthenticationFailureHandler myAuthenticationFailureHandler() {
		return new CustomAuthFailureHandler();
	}

}
