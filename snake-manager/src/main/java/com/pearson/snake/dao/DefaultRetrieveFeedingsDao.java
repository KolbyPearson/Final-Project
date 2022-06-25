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
import com.pearson.snake.entity.Feeding;
import com.pearson.snake.entity.FoodEaten;
import com.pearson.snake.entity.Snake;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultRetrieveFeedingsDao implements RetrieveFeedingsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Feeding> fetchFeedings(String name) {
    log.debug("dao name={}", name);
    String snakeId = findSnakeId(name);
    String sql = "SELECT * FROM feeding where snake_id = :snakeId";

    Map<String, Object> params = new HashMap<>();
    params.put("snakeId", snakeId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Feeding mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        return Feeding.builder()
            .feedingId(rs.getInt("feeding_id"))
            .snakeId(rs.getInt("snake_id"))
            .feedTimestamp(rs.getTimestamp("feed_timestamp"))
            .foodEaten(FoodEaten.valueOf(rs.getString("was_food_consumed")))
            .build();
      }});
  }


  private String findSnakeId(String name) {
    String sql = "SELECT snake_id FROM snakes WHERE snake_name = :snake_name";

    Map<String, Object> params = new HashMap<>();
    params.put("snake_name", name);

    List<Snake> snakeId = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Snake mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Snake.builder().snakeId(rs.getInt("snake_id")).build();
      }
    });
    if (snakeId.isEmpty()) {
      String msg = String.format("No snake found for name=%s", name);
      throw new NoSuchElementException(msg);
    }
    String i = snakeId.toString();
    String id = i.replaceAll("\\D+", "");
    int cleanId = Integer.parseInt(id);

    return String.valueOf(cleanId);
  }
}