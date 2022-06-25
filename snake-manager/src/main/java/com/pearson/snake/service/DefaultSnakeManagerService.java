package com.pearson.snake.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pearson.snake.dao.SnakeManagerDao;
import com.pearson.snake.entity.Snake;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultSnakeManagerService implements SnakeManagerService {

  @Autowired
  private SnakeManagerDao snakeManagerDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Snake> fetchSnakes(String user) {
    log.info("user={}", user);
    
    List<Snake> snakes = snakeManagerDao.fetchSnakes(user);
    
    if(snakes.isEmpty()) {
      String msg = String.format("No snakes found for user=%s", user);
      
      throw new NoSuchElementException(msg);
    }
    Collections.sort(snakes);
    return snakes;
  }
}