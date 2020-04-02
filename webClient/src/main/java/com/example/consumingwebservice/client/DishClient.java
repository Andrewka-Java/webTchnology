package com.example.consumingwebservice.client;


import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class DishClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(DishClient.class);

    public GetDishByIdResponse getDishById(Integer id) {

        //        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
//                        new SoapActionCallback(
//                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"
//                        ));


        GetDishByIdRequest request = new GetDishByIdRequest();
        request.setId(id);

        LOGGER.info("Request is {}", request);

        return (GetDishByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/dish", request);
    }

    public GetAllDishResponse getAllDish() {
        GetAllDishRequest request = new GetAllDishRequest();
        LOGGER.info("Request is {}", request);

        return (GetAllDishResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/dish", request);

    }

    public void deleteDish(Integer id) {
        GetDeleteRequest request = new GetDeleteRequest();
        request.setId(id);
        LOGGER.info("Request is {}", request);

        getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/dish", request);
    }

    public void updateDish(Dish dish) {
        GetUpdateDishRequest request = new GetUpdateDishRequest();
        request.setDish(dish);
        LOGGER.info("Request is {}", request);

        getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/dish", request);
    }

    public void addDish(Dish dish) {
        GetAddDishRequest request = new GetAddDishRequest();
        request.setDish(dish);
        LOGGER.info("Request is {}", request);

        getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/dish", request);
    }

}