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
import com.pearson.snake.entity.Snake;
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultUpdateSnakeDao implements UpdateSnakeDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void updateSnake(int snakeId, String name, SnakeSex sex, SnakeSpecies species) {
    log.debug("snakeid={}, name={}, sex={}, species={}", snakeId, name, sex, species);
    checkId(snakeId);
    String id = String.valueOf(snakeId);
    String sexToString = sex.toString();
    String speciesToString = species.toString();
    String sql = 
        "UPDATE snakes SET snake_name= :name, sex= :sex, species= :species WHERE snake_id= :snakeId;";
    
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    params.put("sex", sexToString);
    params.put("species", speciesToString);
    params.put("snakeId", id);
    
    jdbcTemplate.update(sql, params); 
  }
  
  private void checkId(int snakeid) {
    String sql = "SELECT * FROM snakes where snake_id = :snakeId;";
    
    Map<String, Object> params = new HashMap<>();
    params.put("snakeId", String.valueOf(snakeid));
    
    List<Snake> snake = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Snake mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Snake.builder()
            .snakeId(rs.getInt("snake_id"))
            .snakeName(rs.getString("snake_name"))
            .sex(SnakeSex.valueOf(rs.getString("sex")))
            .species(SnakeSpecies.valueOf((rs.getString("species"))))
            .build();
      }});
    if(snake.isEmpty()) {
      String msg = String.format("No snake found for snakeId=%s", snakeid);
      throw new NoSuchElementException(msg);    
      }
  }
}