package co.edu.udea.practicafinal.repositories;

import co.edu.udea.practicafinal.controllers.ResearcherController;
import co.edu.udea.practicafinal.dtos.ResearchProjectDto;
import co.edu.udea.practicafinal.entities.ResearchProject;
import co.edu.udea.practicafinal.entities.Researcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ResearchProject, String> {
}