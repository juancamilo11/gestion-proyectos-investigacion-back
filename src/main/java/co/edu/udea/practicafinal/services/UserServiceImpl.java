package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.entities.Researcher;
import co.edu.udea.practicafinal.mappers.ResearcherMapper;
import co.edu.udea.practicafinal.repositories.ResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final ResearcherRepository researcherRepository;
  private final ResearcherMapper researcherMapper;

  @Override
  public ResearcherDto checkUserExistence(BasicResearcherInfoDto basicResearcherInfoDto) {
    Optional<Researcher> researcherOptional = this.researcherRepository.findById(basicResearcherInfoDto.getId());

    return researcherOptional
            .map(this.researcherMapper::mapFromEntityToDto)
            .orElseGet(() -> this.researcherMapper
                    .mapFromEntityToDto(this.researcherRepository.save(this.researcherMapper.mapFromDtoToEntity(basicResearcherInfoDto))));
  }
}
