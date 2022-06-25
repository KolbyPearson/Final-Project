package com.pearson.snake.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.entity.Feeding;
import com.pearson.snake.service.RetrieveFeedingsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultRetrieveFeedingsController implements RetrieveFeedingsController {
  
  @Autowired
  private RetrieveFeedingsService retrieveFeedingsService;

  @Override
  public List<Feeding> fetchFeedings(String name) {
    log.debug("controller name={}", name);
    return retrieveFeedingsService.fetchFeedings(name);
  }
}