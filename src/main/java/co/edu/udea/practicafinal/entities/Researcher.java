package co.edu.udea.practicafinal.entities;

import co.edu.udea.practicafinal.entities.helpers.Career;
import co.edu.udea.practicafinal.entities.helpers.EnumRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="researcher")
public class Researcher {

    @Id
    @Column(name = "researcher_id")
    @NotBlank private String id;
    @NotBlank private String displayName;
    @NotBlank private String email;
    @NotBlank private String photoURl;
     private String phoneNumber;
     private LocalDate dateOfEntry;
     private EnumRoles role;
     private String careerName;
     private String careerCode;

    @ManyToMany
    @JoinTable(name = "researcher_research_project_detail",
            joinColumns = @JoinColumn(name = "researcher_id"),
            inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<ResearchProject> researchProjectList;

}
