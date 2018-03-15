package com.minghua.springboot.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-7-19
 */
@Configuration
public class RestTemplateConfig {
//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        return new RestTemplate(factory);
//    }
//
//    /**
//     * @author minghua.chen
//     */
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(300);  //ms
//        factory.setConnectTimeout(500); //ms
//        return factory;
//    }

    private static final int MAX_CONN_TOTAL = 1000;
    private static final int MAX_PER_ROUTE = 1000;

    /**
     * @author minghua.chen
     */
    @Bean
    public RestTemplate restTemplate() {
        //System.out.println(factory.toString());
        return new RestTemplate(clientHttpRequestFactory());
    }

    /**
     * @author minghua.chen
     */
    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(MAX_CONN_TOTAL)
                .setMaxConnPerRoute(MAX_PER_ROUTE)
                .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectTimeout(500); //ms
        factory.setReadTimeout(300); //ms
        System.out.println(factory.toString());
        return factory;
    }
}
