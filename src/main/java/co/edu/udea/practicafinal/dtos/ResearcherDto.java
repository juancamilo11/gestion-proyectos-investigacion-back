package co.edu.udea.practicafinal.dtos;

import co.edu.udea.practicafinal.dtos.helpers.CareerDto;
import co.edu.udea.practicafinal.dtos.helpers.EnumRolesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResearcherDto {

    @NotBlank
    private String id;
    @NotBlank
    private String displayName;
    @NotBlank
    private String email;
    @NotBlank
    private String photoURL;
    private String phoneNumber;
    private LocalDate dateOfEntry;
    private EnumRolesDto role;
    private CareerDto career;


    private List<ResearchProjectDto> researchProjectList;

}
