package co.edu.udea.practicafinal.dtos.researchproject.helpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Clase de Tranferencia de Datos (Dto) para contener la informacion de la duracion del proyecto
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDurationDto {
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate startingDate;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate endingDate;
}
