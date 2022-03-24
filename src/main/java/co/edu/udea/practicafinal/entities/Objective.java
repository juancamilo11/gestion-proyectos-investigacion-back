package co.edu.udea.practicafinal.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Objective {
    private String id;
    private String description;
    private Boolean completed;
}
