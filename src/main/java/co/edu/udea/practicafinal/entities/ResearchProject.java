package co.edu.udea.practicafinal.entities;


import co.edu.udea.practicafinal.entities.helpers.ProjectDuration;
import co.edu.udea.practicafinal.entities.helpers.ProjectObjective;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ResearchProject {
    @Id
    private String id;
    private String name;
    private Double budget;
    private String description;
    private ProjectObjective projectObjective;
    private List<String> researcherIdList;
    private ProjectDuration projectDuration;
}
