package com.pnu.skynet.trainingmanagerapi.config;

import com.pnu.skynet.trainingmanagerapi.constant.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${admin_user.username}")
    private String USERNAME;

    @Value("${admin_user.password}")
    private String PASSWORD;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;


    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/user").permitAll()
                    .antMatchers("/exercise").hasRole(UserRole.ADMIN.name())
                    .anyRequest().hasRole(UserRole.CUSTOMER.name())
                    .and()
                .formLogin()
//                   .loginPage("/login") todo uncomment when page will be ready
                    .permitAll()
//                  .defaultSuccessUrl("/dashboard") todo uncomment when the endpoint will be implemented
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .csrf()
                    .disable()
                .httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder)
                    .and()
                .inMemoryAuthentication()
                    .withUser(USERNAME)
                        .password(passwordEncoder.encode(PASSWORD))
                        .roles(UserRole.ADMIN.name());
    }

}
