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
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import com.pearson.snake.entity.User;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAddSnakesDao implements AddSnakeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void addSnake(String user, String name, SnakeSex sex, SnakeSpecies species) {
    log.debug("user={}, name={}, sex={}, species={}", user, name, sex, species);
    int Id = findUserId(user);
    String userId = String.valueOf(Id);
    String snake_sex = sex.toString();
    String snake_species = species.toString();
    String sql =
        "insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, :user_id, :snake_name, :snake_sex, :species);";

    Map<String, Object> params = new HashMap<>();
    params.put("user_id", userId);
    params.put("snake_name", name);
    params.put("snake_sex", snake_sex);
    params.put("species", snake_species);
    
    jdbcTemplate.update(sql, params);
  }



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
      String msg = String.format("No user found for user=%s", user);
      throw new NoSuchElementException(msg);
    }
    String i = userId.toString();
    String id = i.replaceAll("\\D+", "");
    int cleanId = Integer.parseInt(id);

    return cleanId;
  }
}
