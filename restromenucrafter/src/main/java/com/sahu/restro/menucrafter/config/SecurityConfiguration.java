package com.sahu.restro.menucrafter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.sahu.restro.menucrafter.constants.PermissionConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/vendor/**" , "/images/**", "/lib/**");
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.antMatchers("/", "/login", "/registration", "/forget-password", 
						"/reset-password", "/change-password").permitAll()
				
				.antMatchers(HttpMethod.GET, "/client/admin/dashboard").hasAnyAuthority(PermissionConstants.GLOBAL_ADMINISTRATION)
				.antMatchers(HttpMethod.GET, "/client/restro/dashboard").hasAnyAuthority(PermissionConstants.VIEW_RESTURANT_DASHBOARD, PermissionConstants.GLOBAL_ADMINISTRATION)
				
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/", true)
			.and()
			.csrf().disable()
			.logout() 
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login?logout")
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied")
			.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
				.invalidSessionUrl("/invalid-session")
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false)
				.expiredUrl("/login?session-expire");

		return http.build();
	}

}
