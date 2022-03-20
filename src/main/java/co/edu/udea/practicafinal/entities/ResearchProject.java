package co.edu.udea.practicafinal.entities;


import co.edu.udea.practicafinal.entities.helpers.ProjectDuration;
import co.edu.udea.practicafinal.entities.helpers.ProjectObjective;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ResearchProject {
    @Id
    @NotBlank private String id;
    @NotBlank private String name;
    @NotBlank private Double budget;
    @NotBlank private String description;
    @NotBlank private ProjectObjective projectObjective;
    @NotEmpty private List<Researcher> researcherList;
    @NotEmpty private ProjectDuration projectDuration;
}
