package com.pearson.snake.service;

import java.util.List;
import com.pearson.snake.entity.Feeding;

public interface RetrieveFeedingsService {

  /**
   * @param name
   * @return
   */
  List<Feeding> fetchFeedings(String name);

}
