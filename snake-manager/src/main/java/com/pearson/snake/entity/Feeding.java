package com.pearson.snake.entity;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Feeding {
  private int feedingId;
  private int snakeId;
  private Timestamp feedTimestamp;
  private FoodEaten foodEaten;

}
