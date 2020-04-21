package com.example.endpoint.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WSConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();

        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    //    Using for generate and publishing wsdl-schema
    @Bean(name = "dish")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema dishSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DishPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.net/example/soap");
        wsdl11Definition.setSchema(dishSchema);

        return wsdl11Definition;
    }

//    @Bean
//    public XsdSchemaCollection dishSchemaCollection() {
//        return new XsdSchemaCollection() {
//            @Override
//            public XsdSchema[] getXsdSchemas() {
//                return new XsdSchema[0];
//            }
//
//            @Override
//            public XmlValidator createValidator() {
//                return null;
//            }
//        };
//    }

    @Bean
    public XsdSchema dishSchema() {
        return new SimpleXsdSchema(new ClassPathResource("dish.xsd"));
    }


}
