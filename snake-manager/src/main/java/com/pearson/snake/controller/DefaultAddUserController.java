package com.pearson.snake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pearson.snake.service.AddUserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultAddUserController implements AddUserController {

  @Autowired
  private AddUserService addUserService;
  
  @Override
  public void addUser(String user, String email, String password) {
    log.debug("user={}, email={}, password={}", user, email, password);
    addUserService.addUser(user, email, password);
  }
}