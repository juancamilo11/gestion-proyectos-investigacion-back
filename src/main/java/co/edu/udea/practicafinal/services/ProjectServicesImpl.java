package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;
import co.edu.udea.practicafinal.entities.ResearchProject;
import co.edu.udea.practicafinal.entities.Researcher;
import co.edu.udea.practicafinal.mappers.ProjectMapper;
import co.edu.udea.practicafinal.mappers.ResearcherMapper;
import co.edu.udea.practicafinal.repositories.ProjectRepository;
import co.edu.udea.practicafinal.repositories.ResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class ProjectServicesImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ResearcherRepository researcherRepository;
    private final ResearcherMapper researcherMapper;

    @Override
    public List<ResearcherDto> getAllResearchersByProjectId(String projectId) {

        List<ResearcherDto> researcherDtoList = new ArrayList<>();
        Optional<ResearchProject> projectOptional = this.projectRepository
              .findById(projectId);

        projectOptional.map(researchProject -> researchProject.getResearcherIdList()
                        .stream()
                        .peek(researcherId -> {
                            Optional<Researcher> researcherOptional = this.researcherRepository.findById(researcherId);
                            researcherOptional.ifPresent(researcher -> researcherDtoList
                                    .add(this.researcherMapper.mapFromEntityToDto(researcher)));
                        }).collect(Collectors.toList()));

        return researcherDtoList;
    }

    @Override
    public List<ResearchProjectDto> getAllProjectsByResearcherId(String researcherId) {
        return this.projectRepository
                .findAllByResearcherIdListContaining(researcherId)
                .stream()
                .map(this.projectMapper::mapFromEntityToDto)
                .collect(Collectors.toList());
    }
}