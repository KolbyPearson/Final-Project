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
import com.pearson.snake.entity.User;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSnakeManagerDao implements SnakeManagerDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Snake> fetchSnakes(String user) {
    log.debug("Dao: user={}", user);
    int user_id = findUserId(user);
    String sql = "SELECT * FROM snakes WHERE user_id = :user_id";


    Map<String, Object> params = new HashMap<>();
    params.put("user_id", user_id);
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

  /**
   * @param user
   * @return
   */
  public int findUserId(String user) {
    String sql = "SELECT user_id FROM users WHERE user_name = :user_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("user_name", user);
    
    List<User> userId = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return User.builder().userId(rs.getInt("user_id")).build();
      }});
    if(userId.isEmpty()) {
      String msg = String.format("No snake user found for user=%s", user);
      throw new NoSuchElementException(msg);
    }
    String i = userId.toString();
    String id = i.replaceAll("\\D+","");
    int cleanId = Integer.parseInt(id);
    
    return cleanId;
  }
}