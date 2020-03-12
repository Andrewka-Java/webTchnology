package com.webtechnology.controllers;

import com.webtechnology.dao.DishDao;
import com.webtechnology.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CookController {


    @Autowired
    private DishDao dishDao;

    @GetMapping("/index")
    public String getIndex(Model model) {
        List<Dish> dishes = dishDao.findAll();
        model.addAttribute("dishes", dishes);
        return "index";
    }

    @GetMapping("/dish/{id}")
    public String findDishById(@PathVariable("id") Integer id, Model model) {
        Dish dish = dishDao.findById(id);
        model.addAttribute("dish", dish);
        return "dish";
    }

    @GetMapping("/dish/delete/{id}")
    public String deleteDish(@PathVariable("id") Integer id) {
        dishDao.deleteDish(id);
        return "redirect:/index";
    }

    @GetMapping("/edit-dish/{id}")
    public String gotoEditDish(@PathVariable("id") Integer id, Model model) {
        Dish dish = dishDao.findById(id);
        model.addAttribute("updateDish", dish);
        return "editDish";
    }

    @PostMapping("/add-dish")
    public String addRatingToDish(Dish dish, Model model){
        dishDao.addDish(dish);
        model.addAttribute("dishName", dish.getName());
        model.addAttribute("dishDescription", dish.getDescription());
        model.addAttribute("dishRating", dish.getRating());
        return "redirect:/index";
    }

    @PostMapping("/update-dish/{id}")
    public String updateDish(@PathVariable("id") Integer id, Dish dish) {

        dishDao.updateDish(dish);

        return "redirect:/index";
    }
}
