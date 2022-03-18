package co.edu.udea.practicafinal.dtos;


import co.edu.udea.practicafinal.dtos.helpers.ProjectDurationDto;
import co.edu.udea.practicafinal.dtos.helpers.ProjectObjectiveDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResearchProjectDto {
    @NotBlank private String id;
    @NotBlank private String name;
    @NotBlank private String budget;
    @NotBlank private ProjectObjectiveDto projectObjective;
    @NotBlank private ProjectDurationDto projectDuration;


}
