package com.pearson.snake.dao;

import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;

public interface AddSnakeDao {

  public void addSnake(String user, String name, SnakeSex sex, SnakeSpecies species);
}
