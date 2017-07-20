package com.dipegroup.sample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/20/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */

@EnableMongoAuditing
@Configuration
public class MongoConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> "user";
    }

}
