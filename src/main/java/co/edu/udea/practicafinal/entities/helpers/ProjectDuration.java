package co.edu.udea.practicafinal.entities.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Clase Entidad, modelo para los atributos de la entidad duración de proyectos
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDuration {
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate startingDate;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate endingDate;
}
