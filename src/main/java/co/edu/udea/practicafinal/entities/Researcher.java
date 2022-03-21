package co.edu.udea.practicafinal.entities;

import co.edu.udea.practicafinal.entities.helpers.Career;
import co.edu.udea.practicafinal.entities.helpers.EnumRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Researcher {

    @Id
     private String id;
     private String displayName;
     private String email;
     private String photoURl;

     private String phoneNumber;
     private LocalDate dateOfEntry;
     private EnumRoles role;
     private Career career;
}
