package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;

import java.util.List;

public interface ProjectService {
  List<ResearcherDto> getAllResearchersByProjectId(String projectId);

    List<ResearchProjectDto> getAllProjectsByResearcherId(String researcherId);
}
