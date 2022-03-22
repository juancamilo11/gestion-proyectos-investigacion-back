package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.CareerDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.EnumRolesDto;
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
import java.util.Collections;
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
    public List<ResearchProjectDto> getAllProjectsByResearcherId(String researcherId) {
        return this.projectRepository
                .findAllByResearcherIdListContaining(researcherId)
                .stream()
                .map(this.projectMapper::mapFromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResearchProjectDto createNewProject(ResearchProjectDto researchProjectDto) {
        return this.projectMapper
                .mapFromEntityToDto(this.projectRepository
                        .save(this.projectMapper.mapFromDtoToEntity(researchProjectDto)));
    }

    @Override
    public List<ResearchProjectDto> getAllProjects() {
        List<ResearchProject> researchProjectList = new ArrayList<>();
        this.projectRepository.findAll().forEach(researchProjectList::add);
        return researchProjectList.stream()
                .map(this.projectMapper::mapFromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteResearchProject(String projectId) {
        this.projectRepository.deleteById(projectId);
        return "Project deleted.";
    }

    @Override
    public int deleteUserInProjects(List<ResearchProjectDto> researchProjectDtoList, String userId) {
        return researchProjectDtoList.stream().map(researchProjectDto -> {
            Optional<ResearchProject> researchProjectOptional = this.projectRepository.findById(researchProjectDto.getId());
            return researchProjectOptional.stream().map(researchProject -> {
                List<String> researcherIdList = researchProject.getResearcherIdList();
                researcherIdList.remove(userId);
                researchProject.setResearcherIdList(researcherIdList);
                return this.projectRepository.save(researchProject);
            }).collect(Collectors.toList()).size();
        }).collect(Collectors.toList()).size();
    }

//    public List<ResearcherDto> getAllResearchersByProjectId(String projectId) {
//
//        Optional<ResearchProject> projectOptional = this.projectRepository
//                .findById(projectId);
//
//        return projectOptional.map(researchProject -> researchProject.getResearcherIdList()
//                        .stream()
//                        .map(researcherId -> {
//                            Optional<Researcher> researcherOptional = this.researcherRepository.findById(researcherId);
//                            return researcherOptional.map(researcher -> ResearcherDto.builder()
//                                    .basicResearcherInfo(BasicResearcherInfoDto.builder()
//                                            .id(researcher.getId())
//                                            .displayName(researcher.getDisplayName())
//                                            .email(researcher.getEmail())
//                                            .photoURL(researcher.getPhotoURl())
//                                            .build())
//                                    .phoneNumber(researcher.getPhoneNumber())
//                                    .dateOfEntry(researcher.getDateOfEntry())
//                                    .role(EnumRolesDto.valueOf(researcher.getRole().getDescription()))
//                                    .career(CareerDto.builder()
//                                            .name(researcher.getCareer().getName())
//                                            .code(researcher.getCareer().getCode())
//                                            .build())
//                                    .build()).orElse(null);
//                        }).collect(Collectors.toList()))
//                .orElse(Collections.emptyList());
//
//    }

}