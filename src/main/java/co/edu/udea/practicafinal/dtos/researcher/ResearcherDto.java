package co.edu.udea.practicafinal.dtos.researcher;

import co.edu.udea.practicafinal.dtos.researcher.helpers.BasicResearcherInfoDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.CareerDto;
import co.edu.udea.practicafinal.dtos.researcher.helpers.EnumRolesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Clase de transferencia de datos (Dto) para contener la información de la entidad investigador
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResearcherDto {

    private BasicResearcherInfoDto basicResearcherInfo;
    private String phoneNumber;
    private LocalDate dateOfEntry;
    private EnumRolesDto role;
    private CareerDto career;

}
