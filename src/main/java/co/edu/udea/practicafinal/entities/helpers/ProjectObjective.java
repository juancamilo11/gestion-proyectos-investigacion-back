package co.edu.udea.practicafinal.entities.helpers;

import co.edu.udea.practicafinal.entities.Objective;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase Entidad, modelo para los atributos de la entidad objetivo del proyecto
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectObjective {
  private String generalObjective;
  private List<Objective> specificObjectiveList;
}
