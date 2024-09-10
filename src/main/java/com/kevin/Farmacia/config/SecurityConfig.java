package com.kevin.Farmacia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //@Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests()
    //         .antMatchers("/api/auth/**").permitAll() // Permitir acceso a endpoints de autenticación
    //         .anyRequest().authenticated() // Requiere autenticación para todas las demás solicitudes
    //         .and()
    //         .csrf().disable(); // Desactivar CSRF para simplificar la prueba
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.inMemoryAuthentication() // Configuración simple de autenticación en memoria (modificar según sea necesario)
    //         .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}
