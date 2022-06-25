package com.pearson.snake.service;

import com.pearson.snake.entity.Food;
import com.pearson.snake.entity.FoodEaten;

public interface EnterFeedingService {

  /**
   * @param name
   * @param food
   * @param qty
   * @param eaten
   */
  void addFeeding(String name, Food food, int qty, FoodEaten eaten);

}
