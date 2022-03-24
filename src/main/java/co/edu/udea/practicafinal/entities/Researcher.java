package co.edu.udea.practicafinal.entities;

import co.edu.udea.practicafinal.entities.helpers.Career;
import co.edu.udea.practicafinal.entities.helpers.EnumRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Clase Entidad, modelo para los atributos de la entidad investigador
 */
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
     @DateTimeFormat(style = "yyyy-MM-dd")
     private LocalDate dateOfEntry;
     private EnumRoles role;
     private Career career;
}
