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
import com.pearson.snake.entity.Feeding;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/retrievefeedings")
@OpenAPIDefinition(
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface RetrieveFeedingsController {
  
  // @formatter:off
  @Operation(
      summary = "Returns a list of feedings for a snake",
      description = "Returns a list of feedings for a snake when given snake name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of feedings was returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Feeding.class))),
          @ApiResponse(
              responseCode = "400",
              description = "Not a valid entry",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No feedings were found for snake",
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
              description = "Name of Snake")
      }
   )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Feeding> fetchFeedings(
      @Length(max = Constants.SNAKE_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String name);
 
}
