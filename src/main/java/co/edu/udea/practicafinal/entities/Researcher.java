package co.edu.udea.practicafinal.entities;

import co.edu.udea.practicafinal.entities.helpers.Career;
import co.edu.udea.practicafinal.entities.helpers.EnumRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Researcher {

    @Id
    @NotBlank private String id;
    @NotBlank private String displayName;
    @NotBlank private String email;
    @NotBlank private String photoURl;
     private String phoneNumber;
     private LocalDate dateOfEntry;
     private EnumRoles role;
     private String careerName;
     private String careerCode;
}
