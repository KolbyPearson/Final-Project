package com.pearson.snake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.entity.Food;
import com.pearson.snake.entity.FoodEaten;
import com.pearson.snake.service.EnterFeedingService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEnterFeedingController implements EnterFeedingController {
  
  @Autowired
  private EnterFeedingService enterFeedingService;

  @Override
  public void addFeeding(String name, Food food,
      int qty, FoodEaten eaten) {
    log.debug("name={}, food={}, qty={}, eaten={}", name, food, qty, eaten);
    enterFeedingService.addFeeding(name, food, qty, eaten);
  }
}