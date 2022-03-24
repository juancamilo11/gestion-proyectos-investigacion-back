package co.edu.udea.practicafinal.dtos.researchproject.helpers;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Clase de Tranferencia de Datos (Dto) para contener la informacion de los objetivos generales del proyecto de investigación
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ObjectiveDto {
    @NotBlank private String description;
    @NotBlank private Boolean completed;


}
