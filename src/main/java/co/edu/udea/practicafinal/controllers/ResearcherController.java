package co.edu.udea.practicafinal.controllers;

import co.edu.udea.practicafinal.dtos.UserDto;
import co.edu.udea.practicafinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ResearcherController {
  private final UserService userService;

  @Autowired
  public ResearcherController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/post/user")
  public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<UserDto>(this.userService.createNewUser(userDto), HttpStatus.OK);
  }
}
