package com.pearson.snake.service;

import java.util.List;
import com.pearson.snake.entity.Snake;

public interface SnakeManagerService {

  List<Snake> fetchSnakes(String user);

}
