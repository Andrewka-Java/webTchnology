package com.webtechnology.endpoint;

import com.webtechnology.dao.DishDao;
import net.spring.example.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DishEndpoint {

    private static final String NAMESPACE_URI = "http://spring.net/example/soap";

    @Autowired
    private DishDao dishDao;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDishByIdRequest")
    @ResponsePayload
    public GetDishByIdResponse getDishByIdRequest(@RequestPayload GetDishByIdRequest request) {

        GetDishByIdResponse response = new GetDishByIdResponse();
        response.setDish(dishDao.findById(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllDishRequest")
//    @Action(NAMESPACE_URI + "/getAllDishRequest")
    @ResponsePayload
    public GetAllDishResponse getAllDishResponse(@RequestPayload GetAllDishRequest request) {

        GetAllDishResponse response = new GetAllDishResponse();
        response.getListOfDishes().addAll(dishDao.findAll());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDeleteRequest")
    public void deleteDish(@RequestPayload GetDeleteRequest request) {
        dishDao.deleteDish(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUpdateDishRequest")
    public void updateDish(@RequestPayload GetUpdateDishRequest request) {
        dishDao.updateDish(request.getDish());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddDishRequest")
    public void addDish(@RequestPayload GetAddDishRequest request) {
        dishDao.addDish(request.getDish());
    }
}
