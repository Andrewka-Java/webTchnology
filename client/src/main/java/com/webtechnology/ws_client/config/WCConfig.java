package com.webtechnology.ws_client.config;

import com.webtechnology.ws_client.DishClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WCConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("com.webtechnology.ws_model");
        return marshaller;
    }

    @Bean
    public DishClient countryClient(Jaxb2Marshaller marshaller) {
        DishClient client = new DishClient();

        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
