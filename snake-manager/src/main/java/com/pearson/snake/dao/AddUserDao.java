package com.pearson.snake.dao;

public interface AddUserDao {

  /**
   * @param user
   * @param email
   * @param password
   */
  void addUser(String user, String email, String password);

}
