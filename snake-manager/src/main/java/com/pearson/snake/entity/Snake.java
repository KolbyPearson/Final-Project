package com.pearson.snake.entity;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Snake implements Comparable<Snake> {
  private int snakeId;
  private String snakeName;
  private SnakeSex sex;
  private SnakeSpecies species;
  
  @Override
  public int compareTo(Snake that) {
    // @formatter:off
    return Comparator
        .comparing(Snake::getSnakeId)
        .compare(this, that);
}
  
  
}
