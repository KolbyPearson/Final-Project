package com.pearson.snake.dao;

import java.util.List;
import com.pearson.snake.entity.Snake;

public interface DeleteSnakeDao {

  /**
   * @param name
   */
  public void deleteSnake(String name);

  /**
   * @param name
   * @return
   */
   List<Snake> checkSnakes(String name);

}
