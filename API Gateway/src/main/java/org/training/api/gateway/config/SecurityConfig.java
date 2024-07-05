package org.training.api.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(exchange -> exchange
                        //ALLOWING REGISTER API FOR DIRECT ACCESS
                        .pathMatchers("/api/users/register").permitAll()
                        //ALL OTHER APIS ARE AUTHENTICATED
                        .anyExchange().authenticated())
                .csrf(csrf -> csrf.disable()
                        .oauth2Login(Customizer.withDefaults()))
                .oauth2ResourceServer(server -> server
                        .jwt());
        return http.build();
    }
}