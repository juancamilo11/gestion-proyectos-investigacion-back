package co.edu.udea.practicafinal.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "research_project")
public class ResearchProject {
    @Id
    @Column(name = "project_id")
    @NotBlank private String id;
    @NotBlank private String name;
    @NotBlank private String budget;

    @NotBlank private String generalObjective;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id")
    @NotBlank private List<Objective> specificObjective;

    @ManyToMany(mappedBy = "researchProjectList")
    @NotEmpty private List<Researcher> researcherList;


}
