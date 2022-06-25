package com.pearson.snake.controller;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pearson.snake.Constants;
import com.pearson.snake.entity.Snake;
import com.pearson.snake.entity.SnakeSex;
import com.pearson.snake.entity.SnakeSpecies;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/updatesnake")
@OpenAPIDefinition(info = @Info(title = "SnakeBase"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface UpdateSnakeController {

  // @formatter:off
  @Operation(
      summary = "Updates snake information",
      description = "Adds a snake to the database when given: Name, gender, species",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The snake has been succefully updated",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Snake.class))),
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
              name = "snakeId",
              allowEmptyValue = false,
              required = false,
              description = "snakeId of snake"), 
          @Parameter(
              name = "name",
              allowEmptyValue = false,
              required = false,
              description = "snakes name"),
          @Parameter(
              name = "sex",
              allowEmptyValue = false,
              required = false,
              description = "M or F"),
          @Parameter(
              name = "species",
              allowEmptyValue = false,
              required = false,
              description = "species of snake")
      }
   )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  void updateSnake(   
      @RequestParam(required = false) int snakeId,
      @Length(max = Constants.SNAKE_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String name,
      @RequestParam(required = false) SnakeSex sex,
      @RequestParam(required = false) SnakeSpecies species);
}