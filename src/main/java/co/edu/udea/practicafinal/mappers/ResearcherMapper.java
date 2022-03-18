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
                .displayName(researcherDto.getDisplayName())
                .email(researcherDto.getEmail())
                .photoURl(researcherDto.getPhotoURL())
                .phoneNumber(researcherDto.getPhoneNumber())
                .role(EnumRoles.valueOf(researcherDto.getRole().getDescription()))
                .dateOfEntry(researcherDto.getDateOfEntry())
                .careerName(researcherDto.getCareer().getName())
                .careerCode(researcherDto.getCareer().getCode())
                .build();
    }

    public ResearcherDto mapFromEntityToDto(Researcher researcher) {
        return ResearcherDto.builder()
                .id(researcher.getId())
                .displayName(researcher.getDisplayName())
                .email(researcher.getEmail())
                .photoURL(researcher.getPhotoURl())
                .phoneNumber(researcher.getPhoneNumber())
                .role(EnumRolesDto.valueOf(researcher.getRole().getDescription()))
                .dateOfEntry(researcher.getDateOfEntry())
                .career(CareerDto.builder().name(researcher.getCareerName())
                        .code(researcher.getCareerCode()).build())
                .build();
    }
}
