package com.example;


import com.example.dao.DishDao;
import com.example.endpoint.config.WSConfig;
import net.spring.example.soap.Dish;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ws.test.server.MockWebServiceClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.ws.test.server.RequestCreators.withSoapEnvelope;
import static org.springframework.ws.test.server.ResponseMatchers.soapEnvelope;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationWS.class})
class WebServiceTest implements ResourceLoaderAware {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private DishDao dishDao;

    @Autowired
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

    }

    @BeforeEach
    public void createClient() {
        mockClient = MockWebServiceClient.createClient(context);
    }


    private MockWebServiceClient mockClient;
    private ResourceLoader resourceLoader;


    @Test
    void getDishById() throws IOException {
        Resource request = resourceLoader.getResource("/requests/dishByIdRequest.xml");
        Resource response = resourceLoader.getResource("/responses/dishByIdResponse.xml");

        mockClient.sendRequest(withSoapEnvelope(request))
                .andExpect(soapEnvelope(response));

    }

    @Test
    @Order(1)
    void getAllDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/allDishRequest.xml");
        Resource response = resourceLoader.getResource("/responses/allDishResponse.xml");

        mockClient.sendRequest(withSoapEnvelope(request))
                .andExpect(soapEnvelope(response));
    }

    @Test
    void addDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/addDishRequest.xml");

        int sizeBefore = dishDao.findAll().size();

        mockClient.sendRequest(withSoapEnvelope(request));

        int sizeAfter = dishDao.findAll().size();

        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    void updateDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/updateDishRequest.xml");

        Dish dish = dishDao.findById(2);

        mockClient.sendRequest(withSoapEnvelope(request));

        Dish updatedDish = dishDao.findById(2);

        assertNotEquals(dish, updatedDish);
    }

    @Test
    void deleteDish() throws IOException {
        Resource request = resourceLoader.getResource("/requests/deleteDishRequest.xml");

        int sizeBefore = dishDao.findAll().size();

        mockClient.sendRequest(withSoapEnvelope(request));

        int sizeAfter = dishDao.findAll().size();

        assertEquals(sizeBefore - 1, sizeAfter);
    }

    private Dish createDishFixture() {
        Dish dish = new Dish();

        dish.setName("Тестовое блюдо");
        dish.setDescription("Тут должен быть рецепт приготовления тестового блюда");
        dish.setRating(4);

        return dish;
    }

}
