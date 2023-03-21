package com.epam.learning.backendservices.security.config;

import com.epam.learning.backendservices.security.model.Subscription;
import com.epam.learning.backendservices.security.model.Person;
import com.epam.learning.backendservices.security.repository.SubscriptionRepository;
import com.epam.learning.backendservices.security.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
//@EnableWebSecurity
public class SpringConfig {

    private static final Logger log = LoggerFactory.getLogger(SpringConfig.class);

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/person/**").hasRole("USER")
//                .antMatchers("/subscription/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//        http.httpBasic();
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService users(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @Bean
//    public GrantedAuthoritiesMapper authoritiesMapper() {
//        SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
//        authorityMapper.setConvertToUpperCase(true);
//        return authorityMapper;
//    }

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

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, SubscriptionRepository subscriptionRepository) {
        return args -> {
            var person1 = personRepository.save(
                    new Person(null,
                            "Pavel",
                            "Bui",
                            LocalDate.of(1980,9,27)
                    )
            );
            log.info("Preloading {}", person1);
            var person2 = personRepository.save(
                    new Person(null,
                            "Anna",
                            "Bui",
                            LocalDate.of(1983,9,11)
                    )
            );
            log.info("Preloading {}", person2);
            var person3 = personRepository.save(
                    new Person(null,
                            "Uliana",
                            "Bui",
                            LocalDate.of(2009,8,14)
                    )
            );
            log.info("Preloading {}", person3);
            var person4 = personRepository.save(
                    new Person(null,
                            "Serafima",
                            "Bui",
                            LocalDate.of(2012,11,8)
                    )
            );
            log.info("Preloading {}", person4);
            var person5 = personRepository.save(
                    new Person(null,
                            "Antony",
                            "Bui",
                            LocalDate.of(2016,1,31)
                    )
            );
            log.info("Preloading {}", person5);
            var person6 = personRepository.save(
                    new Person(null,
                            "Elisha",
                            "Bui",
                            LocalDate.of(2022,6,22)
                    )
            );
            log.info("Preloading {}", person6);
            var subscription1 = subscriptionRepository.save(
                    new Subscription(null,
                            person1,
                            LocalDate.now().minusDays(1)
                    )
            );
            log.info("Preloading {}", subscription1);
            var subscription2 = subscriptionRepository.save(
                    new Subscription(null,
                            person2,
                            LocalDate.now().minusDays(2)
                    )
            );
            log.info("Preloading {}", subscription2);
            var subscription3 = subscriptionRepository.save(
                    new Subscription(null,
                            person3,
                            LocalDate.now().minusDays(3)
                    )
            );
            log.info("Preloading {}", subscription3);
            var subscription4 = subscriptionRepository.save(
                    new Subscription(null,
                            person4,
                            LocalDate.now().minusDays(4)
                    )
            );
            log.info("Preloading {}", subscription4);
            var subscription5 = subscriptionRepository.save(
                    new Subscription(null,
                            person5,
                            LocalDate.now().minusDays(5)
                    )
            );
            log.info("Preloading {}", subscription5);
            var subscription6 = subscriptionRepository.save(
                    new Subscription(null,
                            person6,
                            LocalDate.now().minusDays(6)
                    )
            );
            log.info("Preloading {}", subscription6);
        };
    }
}
