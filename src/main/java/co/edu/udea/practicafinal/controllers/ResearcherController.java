package co.edu.udea.practicafinal.controllers;

import co.edu.udea.practicafinal.dtos.ResearcherDto;
import co.edu.udea.practicafinal.services.UserService;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
@Log
public class ResearcherController {
  private final UserService userService;
  @Autowired
  public ResearcherController(UserService userService) {
    this.userService = userService;
  }


  @PostMapping("/post/user")
  public ResponseEntity<ResearcherDto> createNewUser(@RequestBody ResearcherDto researcherDto) {
    log.log(Level.INFO, "Ingresando al metodo del controlador Researcher "+researcherDto);
    return new ResponseEntity<ResearcherDto>(this.userService.createNewUser(researcherDto), HttpStatus.OK);
  }
}
