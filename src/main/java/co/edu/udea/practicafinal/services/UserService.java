package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;

public interface UserService {
  ResearcherDto checkUserExistence(BasicResearcherInfoDto basicResearcherInfoDto);
}
