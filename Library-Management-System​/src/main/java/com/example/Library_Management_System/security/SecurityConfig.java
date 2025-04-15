//package com.example.Library_Management_System.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
//                        .requestMatchers("/api/books").hasAnyAuthority("ROLE_ADMIN", "ROLE_AUTHOR", "ROLE_MEMBER")
//                        .requestMatchers(HttpMethod.POST, "/api/books").hasAnyAuthority("ROLE_AUTHOR")
//                        .requestMatchers(HttpMethod.PUT, "/api/books/**").hasAnyAuthority("ROLE_AUTHOR")
//                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasAnyAuthority("ROLE_AUTHOR")
//                        .requestMatchers("/api/users/**").hasAuthority("ROLE_ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}