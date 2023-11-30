package com.tukiservice.security.config.Supplier;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpBasicDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor


public class SecurityConfig {

    @Bean
    @SuppressWarnings("removal")
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

return httpSecurity

        .authorizeHttpRequests(authRequest->
                authRequest
                        .requestMatchers("/api/supplier").permitAll()
                        .anyRequest().authenticated())
        .formLogin()
        .successHandler(successHandler())
        .permitAll()
        .and()
        .httpBasic()
        .and()
        .build();

}

    public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authentication) -> {
            response.sendRedirect("/api/supplier");
        });
    }
}
