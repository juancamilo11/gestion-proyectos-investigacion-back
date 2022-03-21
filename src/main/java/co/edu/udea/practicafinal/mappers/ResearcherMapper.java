package co.edu.udea.practicafinal.mappers;

import co.edu.udea.practicafinal.dtos.researcher.ResearcherDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.CareerDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.EnumRolesDto;
import co.edu.udea.practicafinal.entities.Researcher;
import co.edu.udea.practicafinal.entities.helpers.Career;
import co.edu.udea.practicafinal.entities.helpers.EnumRoles;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ResearcherMapper {
    public Researcher mapFromDtoToEntity(ResearcherDto researcherDto) {
        return Researcher.builder()
                .id(researcherDto.getBasicResearcherInfo().getId())
                .displayName(researcherDto.getBasicResearcherInfo().getDisplayName())
                .email(researcherDto.getBasicResearcherInfo().getEmail())
                .photoURl(researcherDto.getBasicResearcherInfo().getPhotoURL())
                .phoneNumber(researcherDto.getPhoneNumber())
                .role(EnumRoles.valueOf(researcherDto.getRole().getDescription()))
                .dateOfEntry(researcherDto.getDateOfEntry())
                .career(Career.builder()
                        .name(researcherDto.getCareer().getName())
                        .code(researcherDto.getCareer().getCode())
                        .build())
                .build();
    }

    public ResearcherDto mapFromEntityToDto(Researcher researcher) {
        return ResearcherDto.builder()
                .basicResearcherInfo(BasicResearcherInfoDto.builder()
                        .id(researcher.getId())
                        .displayName(researcher.getDisplayName())
                        .email(researcher.getEmail())
                        .build())
                .phoneNumber(researcher.getPhoneNumber())
                .role(EnumRolesDto.valueOf(researcher.getRole().name()))
                .dateOfEntry(researcher.getDateOfEntry())
                .career(CareerDto.builder()
                        .name(researcher.getCareer().getName())
                        .code(researcher.getCareer().getCode())
                        .build())
                .build();
    }

    public Researcher mapFromDtoToEntity(BasicResearcherInfoDto basicResearcherInfoDto) {
        return Researcher.builder()
                .id(basicResearcherInfoDto.getId())
                .displayName(basicResearcherInfoDto.getDisplayName())
                .email(basicResearcherInfoDto.getEmail())
                .photoURl(basicResearcherInfoDto.getPhotoURL())
                //Optional fields
                .career(Career.builder().name("NN").code("NN").build())
                .role(EnumRoles.RESEARCHER)
                .dateOfEntry(LocalDate.now())
                .phoneNumber("NN")
                .build();
    }
}
