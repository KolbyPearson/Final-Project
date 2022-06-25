package com.pearson.snake.controller;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pearson.snake.Constants;
import com.pearson.snake.entity.Feeding;
import com.pearson.snake.entity.Food;
import com.pearson.snake.entity.FoodEaten;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/addfeeding")
@OpenAPIDefinition(
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface EnterFeedingController {

  // @formatter:off
  @Operation(
      summary = "Adds a new feeding to the database",
      description = "Adds a feeding to the database when given: Snake Name, Food Type, qty, Was eaten",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A feeding has been added",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Feeding.class))),
          @ApiResponse(
              responseCode = "400",
              description = "Not valid parameters",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Not Found",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "name",
              allowEmptyValue = false,
              required = false,
              description = "name of snake fed"), 
          @Parameter(
              name = "food",
              allowEmptyValue = false,
              required = false,
              description = "what food was given"),
          @Parameter(
              name = "qty",
              allowEmptyValue = false,
              required = false,
              description = "number of food items consumed"),
          @Parameter(
              name = "eaten",
              allowEmptyValue = false,
              required = false,
              description = "Was the food item consumed or rejected")
      }
   )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  void addFeeding(
      @Length(max = Constants.SNAKE_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Food food,
      @RequestParam(required = false) int qty,
      @RequestParam(required = false) FoodEaten eaten);
}