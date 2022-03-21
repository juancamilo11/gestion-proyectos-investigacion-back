package co.edu.udea.practicafinal.dtos.researchproject;


import co.edu.udea.practicafinal.dtos.researchproject.helpers.ProjectDurationDto;
import co.edu.udea.practicafinal.dtos.researchproject.helpers.ProjectObjectiveDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResearchProjectDto {
    @NotBlank private String id;
    @NotBlank private String name;
    @Min(value = 0) private Double budget;
    @NotNull private ProjectObjectiveDto projectObjective;
    @NotNull private ProjectDurationDto projectDuration;
    @NotBlank private String description;
    @NotEmpty private List<String> researcherIdList;
}
