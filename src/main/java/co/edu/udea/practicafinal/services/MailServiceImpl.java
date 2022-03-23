package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.researchproject.ResearchProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{
    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender javaMailSender;

    public static void main(String[] args) {
        sendMessageToUserAddedToResearchProjectTest("joanri2020@gmail.com",ResearchProjectDto.builder().name("proyecto pruebas").build());
    }

    public static void sendMessageToUserAddedToResearchProjectTest(String to, ResearchProjectDto researchProjectDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("gestion.proyectos.inv.udea@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("¡Saludos, Bienvenido al proyecto de investicación: "+researchProjectDto.getName()+"!");
        simpleMailMessage.setText("Ya haces parte de nuestro proyecto de investigación, visita este enlace para obtener mas información: https://gestion-proyectos-inv-udea.web.app/");
    }
    @Override
    public void sendMessageToUserAddedToResearchProject(String to, ResearchProjectDto researchProjectDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("¡Saludos, Bienvenido al proyecto de investicación: "+researchProjectDto.getName()+"!");
        simpleMailMessage.setText("Ya haces parte de nuestro proyecto de investigación, visita este enlace para obtener mas información: https://gestion-proyectos-inv-udea.web.app/");
    }



    @Override
    public void sendMessageToUserDeletedFromResearchProject(String to, ResearchProjectDto researchProjectDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("¡Se te ha retirado del proyecto de investicación: "+researchProjectDto.getName()+"!");
        simpleMailMessage.setText("Ya no perteneces al proyecto de investigación");
    }
}
