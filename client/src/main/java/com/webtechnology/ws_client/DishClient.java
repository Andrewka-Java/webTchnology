package com.webtechnology.ws_client;

import com.webtechnology.ws_model.GetDishByIdRequest;
import com.webtechnology.ws_model.GetDishByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class DishClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(DishClient.class);


    public GetDishByIdResponse getDishByIdResponse(Integer id) {

        GetDishByIdRequest request = new GetDishByIdRequest();
        request.setId(id);

        LOGGER.info("LOGGING request: {}", request);

        return (GetDishByIdResponse) getWebServiceTemplate()
            .marshalSendAndReceive("http://localhost:8080/ws/dish", request);
    }
}
