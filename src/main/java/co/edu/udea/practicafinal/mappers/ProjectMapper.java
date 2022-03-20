package co.edu.udea.practicafinal.mappers;

import co.edu.udea.practicafinal.dtos.ResearchProjectDto;
import co.edu.udea.practicafinal.dtos.ResearcherDto;
import co.edu.udea.practicafinal.dtos.helpers.ObjectiveDto;
import co.edu.udea.practicafinal.dtos.helpers.ProjectDurationDto;
import co.edu.udea.practicafinal.dtos.helpers.ProjectObjectiveDto;
import co.edu.udea.practicafinal.entities.ResearchProject;
import co.edu.udea.practicafinal.entities.helpers.ProjectDuration;
import co.edu.udea.practicafinal.entities.helpers.ProjectObjective;
import co.edu.udea.practicafinal.entities.Objective;
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
      .researcherList(researchProjectDto.getResearcherDtoList().stream().map(this.researcherMapper::mapFromDtoToEntity).collect(Collectors.toList()))
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
      .researcherDtoList(researchProject.getResearcherList().stream().map(this.researcherMapper::mapFromEntityToDto).collect(Collectors.toList()))
      .projectDuration(ProjectDurationDto.builder()
        .startingDate(researchProject.getProjectDuration().getStartingDate())
        .endingDate(researchProject.getProjectDuration().getEndingDate())
        .build())
      .build();
  }
}