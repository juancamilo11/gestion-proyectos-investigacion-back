package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.ResearcherDto;
import co.edu.udea.practicafinal.mappers.ProjectMapper;
import co.edu.udea.practicafinal.mappers.ResearcherMapper;
import co.edu.udea.practicafinal.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class ProjectServicesImpl implements ProjectService {
  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;
  private final ResearcherMapper researcherMapper;

  @Override
  public List<ResearcherDto> getAllResearchersByProjectId(String projectId) {
    return this.projectRepository.findById(projectId).map(researchProject -> researchProject.getResearcherList().stream().map(this.researcherMapper::mapFromEntityToDto).collect(Collectors.toList())).orElse(Collections.emptyList());
  }
}