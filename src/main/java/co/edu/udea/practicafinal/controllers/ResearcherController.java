package co.edu.udea.practicafinal.controllers;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.EnumRolesDto;
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
@CrossOrigin(origins = "http://localhost:3000/")
//@CrossOrigin(origins = "https://gestion-proyectos-inv-udea.web.app/")
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

  @GetMapping("/get/users")
  public ResponseEntity<List<ResearcherDto>> getAllusers() {
    log.log(Level.INFO, "[ResearcherController] Ingresando al metodo getAllusers del controlador Researcher con ProjectId");
    return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
  }

  @DeleteMapping("/delete/user/{userId}")
  public ResponseEntity<String> deleteUserById(@PathVariable String userId) {
    log.log(Level.INFO, "[ProjectController] Ingresando al metodo deleteUserById del controlador Project " + userId);
    ResponseEntity<String> unAuthorizedResponse = executeUserEliminationProcess(userId);
    if (unAuthorizedResponse != null) return unAuthorizedResponse;
    this.userService.deleteUser(userId);
    return new ResponseEntity<>("Se ha eliminado el usuario con éxito", HttpStatus.OK);
  }


  @PutMapping("/put/user/{userId}/role/{selectedRole}")
  public ResponseEntity<String> changeUserRole(@PathVariable String userId, @PathVariable EnumRolesDto selectedRole) {
    log.log(Level.INFO, "[ProjectController] Ingresando al metodo changeUserRole del controlador Project " + userId);
    ResponseEntity<String> unAuthorizedResponse = executeUserEliminationProcess(userId);
    if (unAuthorizedResponse != null) return unAuthorizedResponse;
    this.userService.changeUserRole(userId, selectedRole);
    return new ResponseEntity<>("Se ha actualizado el rol del usuario con éxito", HttpStatus.OK);
  }

  private ResponseEntity<String> executeUserEliminationProcess(String userId) {
    List<ResearchProjectDto> researchProjectDtoList = this.projectService.getAllProjectsByResearcherId(userId);
    ResearcherDto researcherDto = this.userService.getUserById(userId);
    if (researcherDto == null) return new ResponseEntity<>("El usuario con id " + userId + " no existe en la aplicación.", HttpStatus.NOT_FOUND);
    if(researcherDto.getRole().equals(EnumRolesDto.RESEARCH_LEADER)) {
      this.projectService.deleteProjectsByLeaderId(researchProjectDtoList, userId);
    } else {
      this.projectService.deleteUserInProjects(researchProjectDtoList, userId);
    }
    return null;
  }
}
