package com.pearson.snake.dao;

import java.util.List;
import com.pearson.snake.entity.Snake;

public interface SnakeManagerDao {

  /**
   * @param user
   * @return
   */
  List<Snake> fetchSnakes(String user);

}
