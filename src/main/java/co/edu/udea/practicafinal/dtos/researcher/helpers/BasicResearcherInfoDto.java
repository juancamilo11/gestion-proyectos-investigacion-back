package co.edu.udea.practicafinal.dtos.researcher.helpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Clase de Transferencia de datos (Dto) para contener la información basica de la entidad del Investigador
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class BasicResearcherInfoDto {
    @NotBlank
    private String id;
    @NotBlank
    private String displayName;
    @NotBlank
    private String email;
    @NotBlank
    private String photoURL;
}
