package co.edu.udea.practicafinal.entities.helpers;

import co.edu.udea.practicafinal.dtos.helpers.ObjectiveDto;
import co.edu.udea.practicafinal.entities.Objective;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectObjective {
  private String generalObjective;
  private List<Objective> specificObjectiveList;
}
