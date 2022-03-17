package co.edu.udea.practicafinal.dtos.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProjectObjectiveDto {
    @NotBlank private String generalObjective;
    @NotBlank private List<ObjectiveDto> specificObjectiveList;

}
