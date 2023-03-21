package com.softuni.toolmarket.config;

import com.softuni.toolmarket.model.enums.UserRoleEnum;
import com.softuni.toolmarket.repository.UserRepository;
import com.softuni.toolmarket.service.impl.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final   UserRepository userRepository;

    public SecurityConfig (UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests().
                requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                .requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name())
                .requestMatchers("/pages/users").hasRole(UserRoleEnum.USER.name())
                .requestMatchers("/pages/company").hasRole(UserRoleEnum.COMPANY.name())
                .anyRequest().authenticated().and().formLogin()
                .loginPage("/users/login")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("/",true)
                .failureForwardUrl("/users/login-error")
                .and()
                .logout()
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService (UserRepository userRepository){
        return new AppUserDetailsService(userRepository);
    }
}
