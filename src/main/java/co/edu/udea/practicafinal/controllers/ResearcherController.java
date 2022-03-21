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
@CrossOrigin(origins = "http://localhost:3000")
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

  @GetMapping("/get/users/project/{projectId}")
  public ResponseEntity<List<ResearcherDto>> getAllResearchersByProjectId(@PathVariable String projectId) {
    log.log(Level.INFO, "[ResearcherController] Ingresando al metodo getAllResearchersByProjectId del controlador Researcher con Id" + projectId);
    return new ResponseEntity<>(this.projectService.getAllResearchersByProjectId(projectId), HttpStatus.OK);
  }

}
