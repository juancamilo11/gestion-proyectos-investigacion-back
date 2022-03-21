package co.edu.udea.practicafinal.dtos.researchproject.helpers;

import co.edu.udea.practicafinal.dtos.researchproject.helpers.ObjectiveDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectObjectiveDto {
    @NotBlank private String generalObjective;
    @NotBlank private List<ObjectiveDto> specificObjectiveList;
}
