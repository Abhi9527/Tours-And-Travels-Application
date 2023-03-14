package com.toursandtravels.config.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.toursandtravels.filters.JWTRequestFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Autowired
	private JWTRequestFilter filter;

	@Bean
	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
		System.out.println("In Authorize Request of Url Mappers");

		http
		.cors()
		.and()
		.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint((request, response, ex) -> {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
		})
		.and()
		.authorizeRequests()
		//Get all Employee details which only admin and HR Department
		.antMatchers( "/**").permitAll()
//		.antMatchers( "/admin/{userName}/createprofile").hasRole("ADMIN")
//		.antMatchers( "/admin/alladmindetails").hasRole("ADMIN")
//		.antMatchers( "/admin/profile/{userName}").hasRole("ADMIN")
//		.antMatchers( "/customer/view").hasRole("ADMIN")
//		.antMatchers( "/iternery/additerneries").hasRole("ADMIN")
//		.antMatchers( "/iternery/Updateiterneries").hasRole("ADMIN")
//		.antMatchers( "/iternery/deleteiternery/{iterneryId}").hasRole("ADMIN")
		
		.antMatchers( "/auth/**", "/swagger*/**", "/v*/api-docs/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticatonMgr(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
