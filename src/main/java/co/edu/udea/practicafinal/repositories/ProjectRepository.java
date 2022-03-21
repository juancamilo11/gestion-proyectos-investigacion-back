package co.edu.udea.practicafinal.repositories;

import co.edu.udea.practicafinal.entities.ResearchProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<ResearchProject, String> {

    List<ResearchProject> findAllByResearcherIdListContaining(String id);

}