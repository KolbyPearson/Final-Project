package com.pearson.snake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearson.snake.dao.AddSnakeDao;
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultAddSnakeService implements AddSnakeService {

  @Autowired
  private AddSnakeDao addSnakeDao;
  
  @Override
  public void addSnake(String user, String name, SnakeSex sex, SnakeSpecies species) {
    log.debug("user={}, name={}, sex={}, species={}", user, name, sex, species);
    addSnakeDao.addSnake(user, name, sex, species);
  }

}
