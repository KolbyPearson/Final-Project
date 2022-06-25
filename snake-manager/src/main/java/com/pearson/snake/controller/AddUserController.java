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
import com.pearson.snake.entity.User;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/adduser")
@OpenAPIDefinition(info = @Info(title = "My Snakes"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface AddUserController {

  // @formatter:off
  @Operation(
      summary = "Adds a user",
      description = "Adds a user to the database when given: username, email, password",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The user was added succesfully",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = User.class))),
          @ApiResponse(
              responseCode = "400",
              description = "Invalid characters/length used",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Not found",
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
              description = "Your username"),
          @Parameter(
              name = "email",
              allowEmptyValue = false,
              required = false,
              description = "Your email"),
          @Parameter(
              name = "password",
              allowEmptyValue = false,
              required = false,
              description = "Your Password")
      }
   )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  void addUser(
      @Length(max = Constants.USER_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String user,
      @Length(max = Constants.EMAIL_MAX_LENGTH)
      @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
      @RequestParam(required = false) String email,
      @Length(max = Constants.PASSWORD_MAX_LENGTH, min = Constants.PASSWORD_MIN_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) String password);
}