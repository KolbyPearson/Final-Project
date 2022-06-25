package com.pearson.snake.dao;

import com.pearson.snake.entity.Food;

public interface EnterFoodTypeDao {

  /**
   * @param food
   */
  void addFoodType(Food food, int qty);

}
