package com.pearson.snake.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.pearson.snake.entity.Feeding;
import com.pearson.snake.entity.Food;
import com.pearson.snake.entity.FoodType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEnterFoodTypeDao implements EnterFoodTypeDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private NamedParameterJdbcTemplate npJdbcTemplate;

  @Override
  public void addFoodType(Food food, int qty) {
    log.debug("DEFTD food={}, qty={}", food, qty);
    String feedingId = findFeedingId();
    System.out.println(feedingId);
    String foodId = findFoodId(food);
    System.out.println(foodId);

    String sql =
        "INSERT INTO feeding_content (feeding_id, food_type_id, quantity) values( :feedId, :foodId, :qty);";
    Map<String, Object> params = new HashMap<>();
    params.put("feedId", feedingId);
    params.put("foodId", foodId);
    params.put("qty", String.valueOf(qty));
    
    npJdbcTemplate.update(sql, params);
  }


  /**
   * @param food
   * @return
   */
  private String findFoodId(Food food) {
    String sql = "SELECT * FROM food_type WHERE food = :food;";

    Map<String, Object> params = new HashMap<>();
    params.put("food", food.toString());

    List<FoodType> foodType = npJdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public FoodType mapRow(ResultSet rs, int rowNum) throws SQLException {
        return FoodType.builder().foodId(rs.getInt("food_type_id")).build();
      }
    });

    String i = foodType.toString();
    return i.replaceAll("\\D+", "");
  }



  /**
   * @return
   */
  private String findFeedingId() {
    String sql = "SELECT * FROM feeding ORDER BY feeding_id DESC LIMIT 1;";

    List<Feeding> feeding = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Feeding mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Feeding.builder().feedingId(rs.getInt("feeding_id")).build();
      }
    });

    String i = feeding.toString();
    String id = i.replaceAll("\\D+", "");
    StringBuffer sb = new StringBuffer(id);
    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
  }
}
