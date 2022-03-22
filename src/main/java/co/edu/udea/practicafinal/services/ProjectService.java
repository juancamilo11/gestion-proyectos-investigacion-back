package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;

import java.util.List;

public interface ProjectService {

    List<ResearchProjectDto> getAllProjectsByResearcherId(String researcherId);

    ResearchProjectDto createNewProject(ResearchProjectDto researchProjectDto);

    List<ResearchProjectDto> getAllProjects();

    String deleteResearchProject(String projectId);

    int deleteUserInProjects(List<ResearchProjectDto> researchProjectDtoList, String userId);
}
