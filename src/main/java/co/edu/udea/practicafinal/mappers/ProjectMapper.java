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

@RequiredArgsConstructor
@Component
public class ProjectMapper {
  private final ResearcherMapper researcherMapper;

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