package co.edu.udea.practicafinal.entities;

import co.edu.udea.practicafinal.dtos.helpers.EnumRolesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  private String id;

  private String name;
  private String email;
  private String photoURL;
  private String phoneNumber;
  private EnumRolesDto role;
  private LocalDate dateOfEntry;
}
