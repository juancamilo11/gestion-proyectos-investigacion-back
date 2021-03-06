package co.edu.udea.practicafinal.entities.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase Entidad, modelo para los atributos de la entidad carrera
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Career {
    private String name;
    private String code;
}
