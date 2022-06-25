package com.pearson.snake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import com.pearson.snake.service.AddSnakeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultAddSnakeController implements AddSnakeController {

  @Autowired
  private AddSnakeService addSnakeService;
  
  @Override
  public void addSnake(String user, String name, SnakeSex sex, SnakeSpecies species) {
    log.debug("user={}, name={}, sex={}, species={}", user, name, sex, species);
    addSnakeService.addSnake(user, name, sex, species);
  }
}