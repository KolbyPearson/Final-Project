package com.pearson.snake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearson.snake.dao.AddUserDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultAddUserService implements AddUserService {
  
  @Autowired
  private AddUserDao addUserDao;

  @Override
  public void addUser(String user, String email, String password) {
    log.debug("user={}, email={}, password={}", user, email, password);
    addUserDao.addUser(user, email, password);
  }

}
