package com.pearson.snake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.pearson"})
public class SnakeManager {

  public static void main(String[] args) {
    SpringApplication.run(SnakeManager.class, args);

  }

}
