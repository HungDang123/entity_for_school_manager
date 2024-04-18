package com.springboot.project.security;

import com.springboot.project.service.teacherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(teacherService teacherService){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(teacherService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return  authenticationProvider;
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(
//                        configurer->configurer
//                                .requestMatchers("/register/**").permitAll()
//                                .requestMatchers("/css/**", "/images/**", "/js/**", "/webjars/**","/assets/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(
//                        form->form.loginPage("/showLoginPage")
//                                .loginProcessingUrl("/authenticateTheUser")
//                                .defaultSuccessUrl("/")
//                                .permitAll()
//                ).logout(
//                        logout->logout.permitAll()
//                ).exceptionHandling(
//                        configurer->configurer.accessDeniedPage("/showPage403")
//                );
//        return http.build();
//    }
}
