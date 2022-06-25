package com.pearson.snake.dao;

import java.util.List;
import com.pearson.snake.entity.Feeding;

public interface RetrieveFeedingsDao {

  /**
   * @param name
   * @return
   */
  List<Feeding> fetchFeedings(String name);

}
