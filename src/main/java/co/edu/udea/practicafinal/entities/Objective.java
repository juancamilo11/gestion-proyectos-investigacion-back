package co.edu.udea.practicafinal.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Objective {
    @NotBlank private String id;
    @NotBlank private String description;
    @NotBlank private Boolean completed;
}
