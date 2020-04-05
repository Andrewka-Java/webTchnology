package com.webtechnology;


import com.example.consumingwebservice.ApplicationWC;
import com.example.consumingwebservice.client.DishClient;
import com.example.consumingwebservice.client.config.WCConfig;
import com.example.consumingwebservice.wsdl.Dish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ws.test.client.MockWebServiceServer;

import java.io.IOException;

import static org.springframework.ws.test.client.RequestMatchers.anything;
import static org.springframework.ws.test.client.RequestMatchers.soapEnvelope;
import static org.springframework.ws.test.client.ResponseCreators.withSoapEnvelope;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationWC.class, WCConfig.class})
class WebClientTest implements ResourceLoaderAware {

    private MockWebServiceServer mockServer;
    private ResourceLoader resourceLoader;

    @Autowired
    private DishClient client;

    @Autowired
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

    }

    @BeforeEach
    public void createClient() {
        mockServer = MockWebServiceServer.createServer(client);
    }


    @Test
    void getDishById() throws IOException {
        Resource request = resourceLoader.getResource("/requests/dishByIdRequest");
        Resource response = resourceLoader.getResource("/responses/dishByIdResponse");

        mockServer.expect(soapEnvelope(request))
                .andRespond(withSoapEnvelope(response));

        client.getDishById(2);

        mockServer.verify();
    }

    @Test
    void getAllDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/allDishRequest");
        Resource response = resourceLoader.getResource("/responses/allDishResponse");

        mockServer.expect(soapEnvelope(request))
                .andRespond(withSoapEnvelope(response));

        client.getAllDish();

        mockServer.verify();
    }

    @Test
    void addDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/addDishRequest");

        mockServer.expect(anything());

        Dish dish = createDishFixture();

        client.addDish(dish);

        mockServer.verify();
    }

    @Test
    void updateDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/updateDishRequest");

        mockServer.expect(soapEnvelope(request));

        Dish updatedDish = createDishFixture();
        updatedDish.setId(2);

        client.updateDish(updatedDish);

        mockServer.verify();
    }

    @Test
    void deleteDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/deleteDishRequest");

        mockServer.expect(soapEnvelope(request));

        client.deleteDish(3);

        mockServer.verify();
    }

    private Dish createDishFixture() {
        Dish dish = new Dish();

        dish.setName("Тестовое блюдо");
        dish.setDescription("Тут должен быть рецепт приготовления тестового блюда");
        dish.setRating(4);

        return dish;
    }

}
