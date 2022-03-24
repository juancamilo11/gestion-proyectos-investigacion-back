package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;

/**
 * Interfaz para el envio de correos electronicos informativos acerca del proyecto vinculado
 */
public interface MailService {
    /**
     * Motodo para el envio de mensaje de correo electronico cuando se agrega a un proyecto de investigación
     * @param to recibe el correo
     * @param researchProjectDto
     */
    void sendMessageToUserAddedToResearchProject(String to, ResearchProjectDto researchProjectDto);
    void sendMessageToUserDeletedFromResearchProject(String to, ResearchProjectDto researchProjectDto);

}
