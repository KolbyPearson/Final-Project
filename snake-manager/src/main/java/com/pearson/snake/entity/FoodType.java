package com.pearson.snake.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodType {
  private int foodId;
  private Food food;
}
