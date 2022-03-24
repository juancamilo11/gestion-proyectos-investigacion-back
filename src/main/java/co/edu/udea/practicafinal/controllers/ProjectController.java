package co.edu.udea.practicafinal.controllers;

import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;
import co.edu.udea.practicafinal.services.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

/**
 * Clase controller para la comunicación con el Front
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://gestion-proyectos-inv-udea.web.app/")
@RequiredArgsConstructor
@Log
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Metodo obtiene todos los proyectos de un investigador
     * @param researcherId Recibe el Id del investigador
     * @return ResponseEntity<List<ResearchProjectDto>> retorna todos los proyectos relacionado a un investigador
     */
    @GetMapping("/get/projects/user/{researcherId}")
    public ResponseEntity<List<ResearchProjectDto>> getAllProjectsByResearcherId(@PathVariable String researcherId) {
        log.log(Level.INFO, "[ProjectController] Ingresando al metodo getAllProjectsByResearcherId del controlador Project " + researcherId);
        return new ResponseEntity<>(this.projectService.getAllProjectsByResearcherId(researcherId), HttpStatus.OK);
    }

    /**
     * Metodo para crear un nuevo proyecto de investigación
     * @param researchProjectDto Recibe el objeto de tipo Dto(Transferencia de datos) del proyecto a guardar
     * @return ResponseEntity<ResearchProjectDto> Retorna el proyecto almacenado
     */
    @PostMapping("/post/project")
    public ResponseEntity<ResearchProjectDto> createNewProject(@RequestBody ResearchProjectDto researchProjectDto) {
        log.log(Level.INFO, "[ProjectController] Ingresando al metodo createNewProject del controlador Project " + researchProjectDto);
        return new ResponseEntity<>(this.projectService.createNewProject(researchProjectDto), HttpStatus.OK);
    }

    /**
     * Metodo para obtener todos los proyectos almacenados
     * @return ResponseEntity<List<ResearchProjectDto>> retorna todos los proyectos almacenados
     */
    @GetMapping("/get/projects")
    public ResponseEntity<List<ResearchProjectDto>> getAllProjects() {
        log.log(Level.INFO, "[ProjectController] Ingresando al metodo getAllProjects del controlador Project ");
        return new ResponseEntity<>(this.projectService.getAllProjects(), HttpStatus.OK);
    }

    /**
     *Metodo para eliminar el proyecto por medio de su Id
     * @param projectId Recibe parametro con el Id del proyecto
     * @return void
     */
    @DeleteMapping("/delete/project/{projectId}")
    public ResponseEntity<String> deleteResearchProjectById(@PathVariable String projectId) {
        log.log(Level.INFO, "[ProjectController] Ingresando al metodo deleteResearchProjectById del controlador Project " + projectId);
        return new ResponseEntity<>(this.projectService.deleteResearchProject(projectId), HttpStatus.OK);
    }
}
