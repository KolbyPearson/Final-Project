package com.pearson.snake.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearson.snake.dao.RetrieveFeedingsDao;
import com.pearson.snake.entity.Feeding;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRetrieveFeedingsService implements RetrieveFeedingsService {

  @Autowired
  private RetrieveFeedingsDao retrieveFeedingsDao;

  @Override
  public List<Feeding> fetchFeedings(String name) {
    log.debug("service name={}", name);

    List<Feeding> feedings = retrieveFeedingsDao.fetchFeedings(name);

    if (feedings.isEmpty()) {
      String msg2 = String.format("No feedings found for name=%s", name);
      throw new NoSuchElementException(msg2);
    }
    return feedings;
  }
}