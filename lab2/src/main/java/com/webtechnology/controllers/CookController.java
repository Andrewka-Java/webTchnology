package com.webtechnology.controllers;

import com.webtechnology.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookController {


    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/borsh")
    public String getBorsh() {
        return "borsh";
    }

    @GetMapping("/draniki")
    public String getDraniki() {
        return "draniki";
    }

    @GetMapping("/pelmeni")
    public String getPelmeni() {
        return "pelmeni";
    }

    @GetMapping("/add-dish-get")
    public String newDish(Dish dish, Model model) {
        model.addAttribute("dishName", dish.getName());
        model.addAttribute("dishDescription", dish.getDescription());
        model.addAttribute("dishRating", dish.getRating());

        return "newDish";
    }

    @PostMapping("/add-dish-post")
    public String addRatingToDish(Dish dish, Model model){
        model.addAttribute("dishName", dish.getName());
        model.addAttribute("dishDescription", dish.getDescription());
        model.addAttribute("dishRating", dish.getRating());
        return "newDish";
    }
}
