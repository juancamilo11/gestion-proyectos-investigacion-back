package co.edu.udea.practicafinal.mappers;

import co.edu.udea.practicafinal.dtos.ResearcherDto;
import co.edu.udea.practicafinal.dtos.helpers.CareerDto;
import co.edu.udea.practicafinal.dtos.helpers.EnumRolesDto;
import co.edu.udea.practicafinal.entities.Researcher;
import co.edu.udea.practicafinal.entities.helpers.EnumRoles;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class ResearcherMapper {
    public Researcher mapFromDtoToEntity(ResearcherDto researcherDto) {
        return Researcher.builder()
                .id(researcherDto.getId())
                .name(researcherDto.getDisplayName())
                .email(researcherDto.getEmail())
                .photoUrl(researcherDto.getPhotoURL())
                .phone(researcherDto.getPhoneNumber())
                .rol(EnumRoles.valueOf(researcherDto.getRole().getDescription()))
                .dateAdmission(researcherDto.getDateOfEntry())
                .careerName(researcherDto.getCareer().getName())
                .careerCode(researcherDto.getCareer().getCode())
                .build();
    }

    public ResearcherDto mapFromEntityToDto(Researcher researcher) {
        return ResearcherDto.builder()
                .id(researcher.getId())
                .displayName(researcher.getName())
                .email(researcher.getEmail())
                .photoURL(researcher.getPhotoUrl())
                .phoneNumber(researcher.getPhone())
                .role(EnumRolesDto.valueOf(researcher.getRol().getDescription()))
                .dateOfEntry(researcher.getDateAdmission())
                .career(CareerDto.builder().name(researcher.getCareerName())
                        .code(researcher.getCareerCode()).build())
                .build();
    }
}
