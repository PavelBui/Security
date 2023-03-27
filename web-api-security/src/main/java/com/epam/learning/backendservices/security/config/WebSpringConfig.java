package com.epam.learning.backendservices.security.config;

import com.epam.learning.backendservices.security.handler.CustomAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.http.HttpMethod;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class WebSpringConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomAuthenticationFailureHandler authenticationFailureHandler) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/about", "/index", "/login*", "/logout").permitAll()
                .antMatchers(HttpMethod.GET, "/person").hasRole("VIEW_PERSON")
                .antMatchers(HttpMethod.GET, "/subscription").hasRole("VIEW_SUBSCRIPTION")
                .antMatchers(HttpMethod.GET,"/info").hasRole("VIEW_INFO")
                .antMatchers(HttpMethod.GET,"/admin", "/blocked").hasRole("VIEW_ADMIN")
                .antMatchers(HttpMethod.GET,"/secret/**", "secretinfo").hasRole("VIEW_SECRET")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/logoutSuccess")
                .permitAll();
        return http.build();
    }

    @Bean
    public DelegatingPasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }

    @Bean
    public AuthenticationProvider authProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.of(plugins));

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("My-API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.epam.learning.backendservices.security.controller.impl"))
                .paths(PathSelectors.any())
                .build();
    }

}
