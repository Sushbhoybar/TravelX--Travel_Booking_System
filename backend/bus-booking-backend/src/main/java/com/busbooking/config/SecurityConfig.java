package com.busbooking.config;

import com.busbooking.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                .cors(cors -> {})       // <-- Enable CORS

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

                	    .requestMatchers(
                	        "/api/auth/**",
                	        "/api/test/**",
                	        "/api/routes/**",
                	        "/api/schedules/**",
                	        "/api/agent/register"
                	    ).permitAll()

                	    .requestMatchers("/api/admin/**")
                	    .hasRole("ADMIN")
                	    .requestMatchers("/uploads/**").permitAll()

                	    .requestMatchers(
                	        "/v3/api-docs/**",
                	        "/swagger-ui/**",
                	        "/swagger-ui.html"
                	    ).permitAll()
                	    
                	    .requestMatchers("/api/agent/**").hasRole("AGENT")

                	    .anyRequest()
                	    .authenticated()
                	)

                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }
}