package co.edu.udea.practicafinal.mappers;

import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;
import co.edu.udea.practicafinal.dtos.researchproject.helpers.ObjectiveDto;
import co.edu.udea.practicafinal.dtos.researchproject.helpers.ProjectDurationDto;
import co.edu.udea.practicafinal.dtos.researchproject.helpers.ProjectObjectiveDto;
import co.edu.udea.practicafinal.entities.Objective;
import co.edu.udea.practicafinal.entities.ResearchProject;
import co.edu.udea.practicafinal.entities.helpers.ProjectDuration;
import co.edu.udea.practicafinal.entities.helpers.ProjectObjective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
/**
 * Clase que sirve para la conversión de las entidades a Dto y viceversa de la clase proyecto de investigador
 */
@RequiredArgsConstructor
@Component
public class ProjectMapper {
  private final ResearcherMapper researcherMapper;

  /**
   * Metodo para la conversión de un objeto de tipo Dto a Tipo Entidad de la clase proyecto de investigación
   * @param researchProjectDto recibe el objeto de tipo Dto a transformar
   * @return retorna un objeto de tipo entidad
   */
  public ResearchProject mapFromDtoToEntity(ResearchProjectDto researchProjectDto) {
    return ResearchProject.builder()
      .id(researchProjectDto.getId())
      .name(researchProjectDto.getName())
      .description(researchProjectDto.getDescription())
      .budget(researchProjectDto.getBudget())
      .projectObjective(
        ProjectObjective.builder()
          .generalObjective(researchProjectDto.getProjectObjective().getGeneralObjective())
          .specificObjectiveList(researchProjectDto.getProjectObjective()
            .getSpecificObjectiveList().stream()
            .map(objectiveDto -> Objective.builder()
              .description(objectiveDto.getDescription())
              .completed(objectiveDto.getCompleted())
              .build())
            .collect(Collectors.toList()))
          .build()
      )
      .researcherIdList(researchProjectDto.getResearcherIdList())
      .projectDuration(ProjectDuration.builder()
        .startingDate(researchProjectDto.getProjectDuration().getStartingDate())
        .endingDate(researchProjectDto.getProjectDuration().getEndingDate())
        .build())
      .build();
  }

  /**
   * Metodo para la conversión de un objeto de tipo Entidad a Tipo Dto de la clase proyecto de investigación
   * @param researchProject recibe el objeto de tipo Entidad a transformar
   * @return retorna un objeto de tipo Dto
   */
  public ResearchProjectDto mapFromEntityToDto(ResearchProject researchProject) {
    return ResearchProjectDto.builder()
      .id(researchProject.getId())
      .name(researchProject.getName())
      .description(researchProject.getDescription())
      .budget(researchProject.getBudget())
      .projectObjective(
        ProjectObjectiveDto.builder()
          .generalObjective(researchProject.getProjectObjective().getGeneralObjective())
          .specificObjectiveList(researchProject.getProjectObjective()
            .getSpecificObjectiveList().stream()
            .map(objective -> ObjectiveDto.builder()
              .description(objective.getDescription())
              .completed(objective.getCompleted())
              .build())
            .collect(Collectors.toList()))
          .build()
      )
      .researcherIdList(researchProject.getResearcherIdList())
      .projectDuration(ProjectDurationDto.builder()
        .startingDate(researchProject.getProjectDuration().getStartingDate())
        .endingDate(researchProject.getProjectDuration().getEndingDate())
        .build())
      .build();
  }
}