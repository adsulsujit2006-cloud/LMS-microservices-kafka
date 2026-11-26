package com.loan_management_system_user.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()

                // User APIs
                .antMatchers("/api/v1/user/**").permitAll()

                // R.E APIs
                .antMatchers(
                        "/api/v1/R.E/login",
                        "/api/v1/R.E/registor/RE"
                ).permitAll()

                // B.M APIs
                .antMatchers(
                        "/api/v1/B.M/login",
                        "/api/v1/B.M/registor/BM"
                ).permitAll()

                // Branch APIs
                .antMatchers("/api/v1/branches/register").permitAll()

                // Role APIs
                .antMatchers("/api/v1/role/**").permitAll()

                // Swagger APIs
                .antMatchers(
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/v3/api-docs/**",
                        "/webjars/**"
                ).permitAll()

                // Eureka
                .antMatchers("/eureka/**").permitAll()

                // Remaining APIs
                .anyRequest().authenticated()

                .and()
                .httpBasic().disable()
                .formLogin().disable();
    }
}