package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.EnumRolesDto;

import java.util.List;

public interface UserService {

  ResearcherDto checkUserExistence(BasicResearcherInfoDto basicResearcherInfoDto);

  List<ResearcherDto> getAllResearchersInfoByProjectId(String projectId);

  ResearcherDto getUserByEmail(String userEmail);

  List<ResearcherDto> getAllUsers();

  String deleteUser(String userId);

  ResearcherDto getUserById(String userId);

  void changeUserRole(String userId, EnumRolesDto selectedRole);
}
