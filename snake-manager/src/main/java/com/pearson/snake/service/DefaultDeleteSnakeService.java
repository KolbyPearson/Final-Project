package com.pearson.snake.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearson.snake.dao.DeleteSnakeDao;
import com.pearson.snake.entity.Snake;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultDeleteSnakeService implements DeleteSnakeService {

  @Autowired
  private DeleteSnakeDao deleteSnakeDao;

  @Override
  public void deleteSnake(String name) {
    log.debug("name={}", name);

    List<Snake> snakes = deleteSnakeDao.checkSnakes(name);

    if (snakes.isEmpty()) {
      String msg = String.format("No snake found for snakeName=%s", name);

      throw new NoSuchElementException(msg);
    }
    deleteSnakeDao.deleteSnake(name);
  }

}
