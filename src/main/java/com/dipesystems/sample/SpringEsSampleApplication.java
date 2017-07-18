package com.dipesystems.sample;

import com.dipegroup.exceptions.services.exceptions.ExceptionMapper;
import com.dipegroup.exceptions.services.messages.MessagesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/18/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */

@Import(ElasticsearchConfiguration.class)
@SpringBootApplication
public class SpringEsSampleApplication {

    @Bean
    public MessagesService messagesService() {
        return new MessagesService();
    }

    @Bean
    public ExceptionMapper exceptionMapper() {
        return new ExceptionMapper("spring-es-sample", messagesService());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringEsSampleApplication.class, args);
    }

}
