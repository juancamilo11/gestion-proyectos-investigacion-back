package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.ResearcherDto;
import co.edu.udea.practicafinal.mappers.ResearcherMapper;
import co.edu.udea.practicafinal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ResearcherMapper researcherMapper;

  @Override
  public ResearcherDto createNewUser(ResearcherDto researcherDto) {
    return this.researcherMapper
            .mapFromEntityToDto(this.userRepository.save(this.researcherMapper.mapFromDtoToEntity(researcherDto)));
  }
}
