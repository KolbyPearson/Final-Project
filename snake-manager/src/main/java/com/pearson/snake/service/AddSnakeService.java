package com.pearson.snake.service;

import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;

public interface AddSnakeService {

  public void addSnake(String user, String name, SnakeSex sex, SnakeSpecies species);
}
