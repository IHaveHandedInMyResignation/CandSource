package com.cand.source.webconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select login as username, password, enabled from profile where login = ?")
				.authoritiesByUsernameQuery("select login as username, role from profile_role where login = ?")
				.passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		
		http.authorizeRequests().antMatchers("/", "/home").permitAll()
				.antMatchers("/profile", "/profile/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/taskmgr", "/taskmgr/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/forum", "/forum/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/expenses", "/expenses/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/account", "/account/**").hasAnyRole("USER", "ADMIN")
				.and().formLogin().loginProcessingUrl("/j_spring_security_check")
				.loginPage("/login").failureUrl("/login?error=loginFailure").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/home").and().exceptionHandling()
				.accessDeniedPage("/nopermission");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
