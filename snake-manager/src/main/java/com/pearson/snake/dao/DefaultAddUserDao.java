package com.pearson.snake.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAddUserDao implements AddUserDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jbdcTemplate;

  @Override
  public void addUser(String user, String email, String password) {
    log.debug("Dao_Level user={}, email={}, password={}", user, email, password);
    String sql = 
        "INSERT into users (user_name, email, password) values( :user, :email, :password);";
    
    Map<String, Object> params = new HashMap<>();
    params.put("user", user);
    params.put("email", email);
    params.put("password", password);
    
    jbdcTemplate.update(sql, params);
  }
}