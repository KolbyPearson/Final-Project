package com.pearson.snake.controller;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pearson.snake.Constants;
import com.pearson.snake.entity.Snake;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/deletesnake")
@OpenAPIDefinition(info = @Info(title = "SnakeBase"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DeleteSnakeController {

  // @formatter: off
  @Operation(
      summary = "Deletes a snake from the database",
      description = "Deletes a snake from the database when given: Name of snake",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A snake has been deleted",
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
              name = "name",
              allowEmptyValue = false,
              required = false,
              description = "snakes name")
      }
   )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteSnake(
      @Length(max = Constants.SNAKE_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String name); 
}