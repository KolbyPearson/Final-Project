package com.pearson.snake.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.entity.Snake;
import com.pearson.snake.service.SnakeManagerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultSnakeManagerController implements SnakeManagerController{

  @Autowired
  private SnakeManagerService snakeManagerService;
  
  @Override
  public List<Snake> fetchSnakes(String user) {
    log.info("user={}", user);
    return snakeManagerService.fetchSnakes(user);
  }
}