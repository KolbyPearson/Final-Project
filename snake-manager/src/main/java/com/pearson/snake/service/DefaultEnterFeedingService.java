package com.pearson.snake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearson.snake.dao.EnterFeedingDao;
import com.pearson.snake.dao.EnterFoodTypeDao;
import com.pearson.snake.entity.Food;
import com.pearson.snake.entity.FoodEaten;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEnterFeedingService implements EnterFeedingService {

  @Autowired
  private EnterFeedingDao enterFeedingDao;
  
  @Autowired
  private EnterFoodTypeDao enterFoodTypeDao;
  
  @Override
  public void addFeeding(String name, Food food, int qty, FoodEaten eaten) {
    log.debug("name={}, food={}, qty={}, eaten={}", name, food, eaten);
    enterFeedingDao.addFeeding(name, eaten);
    enterFoodTypeDao.addFoodType(food, qty);
  }

}
