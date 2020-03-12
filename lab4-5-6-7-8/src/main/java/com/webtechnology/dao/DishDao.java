package com.webtechnology.dao;


import com.webtechnology.model.Dish;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishDao {

    @Select("SELECT id, name, description, rating FROM dish")
    List<Dish> findAll();

    @Select("SELECT id, name, description, rating FROM dish WHERE id = #{id}")
    Dish findById(@Param("id") Integer id);

    @Delete("DELETE FROM dish WHERE id = #{id}")
    void deleteDish(@Param("id") Integer id);

    @Insert("INSERT INTO dish (name, description, rating) VALUES (#{dish.name}, #{dish.description}, #{dish.rating})")
    void addDish(@Param("dish") Dish dish);

    @Update("UPDATE dish SET name = #{dish.name}, description = #{dish.description}, rating = #{dish.rating} WHERE id = #{dish.id}")
    void updateDish(@Param("dish") Dish dish);
}
