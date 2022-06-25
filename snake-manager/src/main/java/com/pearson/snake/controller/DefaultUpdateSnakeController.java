package com.pearson.snake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import com.pearson.snake.service.UpdateSnakeService;

@RestController
public class DefaultUpdateSnakeController implements UpdateSnakeController {
  
  @Autowired
  private UpdateSnakeService updateSnakeService;

  @Override
  public void updateSnake(int snakeId, String name, SnakeSex sex,
      SnakeSpecies species) {
    updateSnakeService.updateSnake(snakeId, name, sex, species);
  }
}