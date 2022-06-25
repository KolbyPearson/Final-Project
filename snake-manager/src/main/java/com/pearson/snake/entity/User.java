/**
 * 
 */
package com.pearson.snake.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private int userId;
  private String username;
  private String email;
  private String password;
  
}
