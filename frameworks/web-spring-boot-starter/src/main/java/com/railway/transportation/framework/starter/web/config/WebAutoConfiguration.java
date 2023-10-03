package com.railway.transportation.framework.starter.web.config;

import com.railway.transportation.framework.starter.web.GlobalExceptionHandler;
import com.railway.transportation.framework.starter.web.initialize.InitializeDispatcherServletController;
import com.railway.transportation.framework.starter.web.initialize.InitializeDispatcherServletHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Web 组件自动装配
 */
public class WebAutoConfiguration {
    public final static String INITIALIZE_PATH = "/initialize/dispatcher-servlet";

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public InitializeDispatcherServletController initializeDispatcherServletController() {
        return new InitializeDispatcherServletController();
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(5000);
        simpleClientHttpRequestFactory.setReadTimeout(5000);
        return simpleClientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public InitializeDispatcherServletHandler initializeDispatcherServletHandler(RestTemplate template, ConfigurableEnvironment environment) {
        return new InitializeDispatcherServletHandler(template, environment);
    }

}
