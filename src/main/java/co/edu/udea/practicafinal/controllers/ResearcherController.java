package co.edu.udea.practicafinal.controllers;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;
import co.edu.udea.practicafinal.services.ProjectService;
import co.edu.udea.practicafinal.services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000/")
@CrossOrigin(origins = "https://gestion-proyectos-inv-udea.web.app/")
@RequiredArgsConstructor
@Log
public class ResearcherController {
  private final UserService userService;
  private final ProjectService projectService;

  //En uso
  @PostMapping("/post/user")
  public ResponseEntity<ResearcherDto> checkUserExistence(@RequestBody BasicResearcherInfoDto basicResearcherInfoDto) {
    log.log(Level.INFO, "[ResearcherController] Ingresando al metodo createNewUser del controlador Researcher " + basicResearcherInfoDto);
    return new ResponseEntity<>(this.userService.checkUserExistence(basicResearcherInfoDto), HttpStatus.OK);
  }

  @GetMapping("/get/users/{projectId}")
  public ResponseEntity<List<ResearcherDto>> getAllResearchersInfoByProjectId(@PathVariable String projectId) {
    log.log(Level.INFO, "[ResearcherController] Ingresando al metodo getAllResearchersInfoByProjectId del controlador Researcher con ProjectId" + projectId);
    return new ResponseEntity<>(this.userService.getAllResearchersInfoByProjectId(projectId), HttpStatus.OK);
  }

  @GetMapping("/get/user/email/{userEmail}")
  public ResponseEntity<ResearcherDto> getUserByEmail(@PathVariable String userEmail) {
    log.log(Level.INFO, "[ResearcherController] Ingresando al metodo getUserByEmail del controlador Researcher " + userEmail);
    return new ResponseEntity<>(this.userService.getUserByEmail(userEmail), HttpStatus.OK);
  }

}
