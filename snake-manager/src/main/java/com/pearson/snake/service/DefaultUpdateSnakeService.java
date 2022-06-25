package com.pearson.snake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearson.snake.dao.UpdateSnakeDao;
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultUpdateSnakeService implements UpdateSnakeService {
  
  @Autowired
  private UpdateSnakeDao updateSnakeDao;

  @Override
  public void updateSnake(int snakeId, String name, SnakeSex sex,
      SnakeSpecies species) {
    log.debug("");
    updateSnakeDao.updateSnake(snakeId, name, sex, species);
    
  }

}
