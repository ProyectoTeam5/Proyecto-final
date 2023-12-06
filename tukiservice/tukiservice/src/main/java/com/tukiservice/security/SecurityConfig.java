package com.tukiservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(dis->dis.disable())
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers(HttpMethod.POST, "api/supplier/create").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "api/user/create").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/api/supplier").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/api/supplier/profession").permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session->{
                    session.maximumSessions(1);
                    session.invalidSessionUrl("/login");
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .build();
    }
}
