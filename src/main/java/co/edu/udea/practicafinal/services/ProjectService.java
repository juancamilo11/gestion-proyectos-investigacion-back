package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.ResearcherDto;

import java.util.List;

public interface ProjectService {
  List<ResearcherDto> getAllResearchersByProjectId(String projectId);
}
