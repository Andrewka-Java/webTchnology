package com.example.consumingwebservice.client.config;

import com.example.consumingwebservice.client.DishClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class DishConfiguration {


    private static final Logger LOGGER = LoggerFactory.getLogger(DishConfiguration.class);

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("com.example.consumingwebservice.wsdl");

        LOGGER.info("MARSHALLER : {}", marshaller.toString());
        return marshaller;
    }

    @Bean
    public DishClient dishClient(Jaxb2Marshaller marshaller) {
        DishClient client = new DishClient();

        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        LOGGER.info("CLIENT: {}",client.toString());

        return client;
    }
}
