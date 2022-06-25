package com.pearson.snake.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/mysnakes")
@OpenAPIDefinition(info = @Info(title = "My Snakes"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface SnakeManagerController {

  // @formatter:off
  @Operation(
      summary = "Returns a list of users snakes",
      description = "Returns a list of users snake when given username",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of the users snakes is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Snake.class))),
          @ApiResponse(
              responseCode = "400",
              description = "Not a valid username",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No snakes were found for user",
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
              name = "user",
              allowEmptyValue = false,
              required = false,
              description = "Your username")
      }
   )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Snake> fetchSnakes(
      @Length(max = Constants.USER_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String user);
 
}
