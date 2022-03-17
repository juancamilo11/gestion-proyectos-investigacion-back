package co.edu.udea.practicafinal.dtos.helpers;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ObjectiveDto {
    @NotBlank private String description;
    @NotBlank private Boolean completed;


}
