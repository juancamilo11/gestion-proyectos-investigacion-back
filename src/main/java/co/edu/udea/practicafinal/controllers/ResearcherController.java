package co.edu.udea.practicafinal.controllers;

import co.edu.udea.practicafinal.dtos.ResearcherDto;
import co.edu.udea.practicafinal.services.ProjectService;
import co.edu.udea.practicafinal.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
@Log
@RequiredArgsConstructor
public class ResearcherController {
  private final UserService userService;
  private final ProjectService projectService;

  @PostMapping("/post/user")
  public ResponseEntity<ResearcherDto> createNewUser(@RequestBody ResearcherDto researcherDto) {
    log.log(Level.INFO, "Ingresando al metodo del controlador Researcher "+researcherDto);
    return new ResponseEntity<>(this.userService.createNewUser(researcherDto), HttpStatus.OK);
  }

  @GetMapping("/get/users/project/{projectId}")
  public ResponseEntity<List<ResearcherDto>> getAllResearchersByProjectId(@PathVariable String projectId) {
    log.log(Level.INFO, "Ingresando al metodo del controlador \"getAllResearchersByProjectId\": " + projectId);
    return new ResponseEntity<>(this.projectService.getAllResearchersByProjectId(projectId), HttpStatus.OK);
  }
}
