package com.pearson.snake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.service.DeleteSnakeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDeleteSnakeController implements DeleteSnakeController {

  @Autowired
  private DeleteSnakeService deleteSnakeService;
  
  @Override
  public void deleteSnake(String name) {
    log.debug("name={}", name);
    deleteSnakeService.deleteSnake(name);
  }
}