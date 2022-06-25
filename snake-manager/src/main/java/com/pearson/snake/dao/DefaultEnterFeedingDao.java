package com.pearson.snake.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.pearson.snake.entity.FoodEaten;
import com.pearson.snake.entity.Snake;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEnterFeedingDao implements EnterFeedingDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void addFeeding(String name, FoodEaten eaten) {
    log.debug("");
    String sql = 
        "INSERT INTO feeding (snake_id, was_food_consumed) VALUES( :id, :eaten);";
    String id = findSnakeId(name);
    
    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("eaten", eaten.toString());
    
    jdbcTemplate.update(sql, params);
  }
  
  
  /**
   * @param name
   * @return
   */
  private String findSnakeId(String name) {
    String sql = "SELECT snake_id FROM snakes WHERE snake_name = :snake_name";

    Map<String, Object> params = new HashMap<>();
    params.put("snake_name", name);

    List<Snake> snakeId = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Snake mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Snake.builder().snakeId(rs.getInt("snake_id")).build();
      }});
    if(snakeId.isEmpty()) {
      String msg = String.format("No snake found for name=%s", name);
      throw new NoSuchElementException(msg);
    }
    String i = snakeId.toString();
    String id = i.replaceAll("\\D+", "");
    int cleanId = Integer.parseInt(id);

    return String.valueOf(cleanId);
  }
}