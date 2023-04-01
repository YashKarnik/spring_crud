package com.yash.wall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.yash.wall.security.SecurityConstants;
import com.yash.wall.security.filters.CustomAuthenticationFilter;
import com.yash.wall.security.filters.ExceptionHandlerFilter;
import com.yash.wall.security.filters.JWTAuthenticationFilter;
import com.yash.wall.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private CustomAuthenticationManager customAuthenticationManager;
    private ExceptionHandlerFilter exceptionHandlerFilter;
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                customAuthenticationManager);
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/user/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/v3/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(exceptionHandlerFilter, CustomAuthenticationFilter.class)
                .addFilter(customAuthenticationFilter)
                .addFilterAfter(jwtAuthenticationFilter, CustomAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}
