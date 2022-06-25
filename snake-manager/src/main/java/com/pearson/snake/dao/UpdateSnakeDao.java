package com.pearson.snake.dao;

import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;

public interface UpdateSnakeDao {

  /**
   * @param snakeId
   * @param name
   * @param sex
   * @param species
   */
  void updateSnake(int snakeId, String name, SnakeSex sex, SnakeSpecies species);

}
