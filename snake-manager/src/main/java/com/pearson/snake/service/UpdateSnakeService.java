package com.pearson.snake.service;

import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;

public interface UpdateSnakeService {

  /**
   * @param user
   * @param name
   * @param sex
   * @param species
   */
  void updateSnake(int snakeId, String name, SnakeSex sex, SnakeSpecies species);

}
