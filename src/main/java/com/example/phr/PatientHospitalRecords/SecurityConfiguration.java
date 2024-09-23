package com.example.phr.PatientHospitalRecords;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final HospitalAuthenticationFilter hospitalAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.
                            requestMatchers("/hospitalsecurity/api/auth/register").permitAll();
                    authorizationManagerRequestMatcherRegistry.
                            requestMatchers("/hospitalsecurity/api/auth/token").permitAll();
                    authorizationManagerRequestMatcherRegistry.
                    requestMatchers("/hospitalsecurity/api/auth/validate").permitAll();
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                });
            http.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(hospitalAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
