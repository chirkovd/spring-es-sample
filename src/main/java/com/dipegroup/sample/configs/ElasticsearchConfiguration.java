package com.dipegroup.sample.configs;

import com.dipegroup.exceptions.services.messages.MessagesService;
import com.dipegroup.spring.es.services.es.ElasticsearchClientService;
import com.dipegroup.spring.es.services.es.ElasticsearchCriteriaBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Configuration
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private String port;

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public Client client() throws Exception {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", true)
                .build();

        InetSocketTransportAddress address =
                new InetSocketTransportAddress(InetAddress.getByName(host), Integer.parseInt(port));

        return new PreBuiltTransportClient(settings).addTransportAddress(address);
    }

    @Bean
    public ElasticsearchClientService elasticClientService(Client client) {
        ElasticsearchClientService service = new ElasticsearchClientService(client, objectMapper);
        service.verifyConnection();
        return service;
    }

    @Bean
    public HighlightBuilder highlightBuilder() {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<em>");
        highlightBuilder.postTags("</em>");
        return highlightBuilder;
    }

    @Bean
    public ElasticsearchCriteriaBuilder criteriaBuilder(HighlightBuilder highlightBuilder,
                                                        MessagesService messagesService) {
        return new ElasticsearchCriteriaBuilder(highlightBuilder, messagesService);
    }
}
