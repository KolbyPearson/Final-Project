package com.pearson.snake.dao;

import com.pearson.snake.entity.FoodEaten;

public interface EnterFeedingDao {

  /**
   * @param name
   * @param food
   * @param qty
   * @param eaten
   */
  void addFeeding(String name, FoodEaten eaten);

}
