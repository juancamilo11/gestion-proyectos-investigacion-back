package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;

public interface MailService {
    void sendMessageToUserAddedToResearchProject(String to, ResearchProjectDto researchProjectDto);
    void sendMessageToUserDeletedFromResearchProject(String to, ResearchProjectDto researchProjectDto);

}
