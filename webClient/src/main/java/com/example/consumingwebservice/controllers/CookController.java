package com.example.consumingwebservice.controllers;

import com.example.consumingwebservice.client.DishClient;
import com.example.consumingwebservice.client.config.DishConfiguration;
import com.example.consumingwebservice.wsdl.Dish;
import com.example.consumingwebservice.wsdl.GetAllDishResponse;
import com.example.consumingwebservice.wsdl.GetDishByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DishConfiguration.class);


    @Autowired
    private DishClient dishClient;

    @GetMapping("/index")
    public String getIndex(HttpServletRequest request, Model model) {

        String clientIp = request.getRemoteAddr();
        String infoAboutClient = request.getHeader("User-Agent");

        GetAllDishResponse dishes = dishClient.getAllDish();

        model.addAttribute("dishes", dishes);
        model.addAttribute("clientIp", "IP: "+ clientIp + "   BROWSER: "+ infoAboutClient);

        return "index";
    }

    @GetMapping("/dish/{id}")
    public String findDishById(@PathVariable("id") Integer id, Model model) {

        LOGGER.info("DishClient: {}", dishClient);

        GetDishByIdResponse dish = dishClient.getDishById(id);

        model.addAttribute("dish", dish);
        return "dish";
    }

    @GetMapping("/dish/delete/{id}")
    public String deleteDish(@PathVariable("id") Integer id) {
        dishClient.deleteDish(id);
        return "redirect:/index";
    }

    @GetMapping("/edit-dish/{id}")
    public String gotoEditDish(@PathVariable("id") Integer id, Model model) {
        GetDishByIdResponse  dish = dishClient.getDishById(id);
        model.addAttribute("updateDish", dish);
        return "editDish";
    }

    @PostMapping("/add-dish")
    public String addRatingToDish(Dish dish, Model model){
        dishClient.addDish(dish);
        model.addAttribute("dishName", dish.getName());
        model.addAttribute("dishDescription", dish.getDescription());
        model.addAttribute("dishRating", dish.getRating());
        return "redirect:/index";
    }

    @PostMapping("/edit-dish/update-dish/{id}")
    public String updateDish(@PathVariable("id") Integer id, Dish dish) {

        dishClient.updateDish(dish);

        return "redirect:/index";
    }
}
