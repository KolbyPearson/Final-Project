package com.pearson.snake.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class DefaultDeleteSnakeDao implements DeleteSnakeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public void deleteSnake(String name) {
    log.debug("name={}", name);
    String sql = "DELETE FROM snakes WHERE snake_name = :snake_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("snake_name", name);
    
    jdbcTemplate.update(sql, params);
  }

  @Override
  public List<Snake> checkSnakes(String name) {
    log.debug("Dao: name={}", name);
    String sql = "SELECT * FROM snakes WHERE snake_name = :snake_name";


    Map<String, Object> params = new HashMap<>();
    params.put("snake_name", name);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

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
  }
}
