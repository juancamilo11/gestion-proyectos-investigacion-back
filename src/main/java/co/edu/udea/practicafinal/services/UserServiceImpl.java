package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.CareerDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.EnumRolesDto;
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
public class UserServiceImpl implements UserService {

  private final ResearcherRepository researcherRepository;
  private final ProjectRepository projectRepository;

  private final ResearcherMapper researcherMapper;
  private final ProjectMapper projectMapper;


  @Override
  public ResearcherDto checkUserExistence(BasicResearcherInfoDto basicResearcherInfoDto) {
    Optional<Researcher> researcherOptional = this.researcherRepository.findById(basicResearcherInfoDto.getId());

    return researcherOptional
            .map(this.researcherMapper::mapFromEntityToDto)
            .orElseGet(() -> this.researcherMapper
                    .mapFromEntityToDto(this.researcherRepository.save(this.researcherMapper.mapFromDtoToEntity(basicResearcherInfoDto))));
  }

  @Override
  public List<ResearcherDto> getAllResearchersInfoByProjectId(String projectId) {
      Optional<ResearchProject> researchProjectOptional = this.projectRepository.findById(projectId);

    return researchProjectOptional.map(researchProject -> researchProject.getResearcherIdList()
                        .stream()
                        .map(researcherId -> {
                            Optional<Researcher> researcherOptional = this.researcherRepository.findById(researcherId);
                            return researcherOptional.map(researcher -> ResearcherDto.builder()
                                    .basicResearcherInfo(BasicResearcherInfoDto.builder()
                                            .id(researcher.getId())
                                            .displayName(researcher.getDisplayName())
                                            .email(researcher.getEmail())
                                            .photoURL(researcher.getPhotoURl())
                                            .build())
                                    .phoneNumber(researcher.getPhoneNumber())
                                    .dateOfEntry(researcher.getDateOfEntry())
                                    .role(EnumRolesDto.valueOf(researcher.getRole().name()))
                                    .career(CareerDto.builder()
                                            .name(researcher.getCareer().getName())
                                            .code(researcher.getCareer().getCode())
                                            .build())
                                    .build()).orElse(ResearcherDto.builder().role(EnumRolesDto.RESEARCHER).build());
                        }).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
  }

    @Override
    public ResearcherDto getUserByEmail(String userEmail) {
        return this.researcherMapper
                .mapFromEntityToDto(this.researcherRepository
                        .findByEmail(userEmail).orElse(Researcher.builder().build()));
    }
}
