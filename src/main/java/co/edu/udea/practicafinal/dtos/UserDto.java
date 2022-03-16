package co.edu.udea.practicafinal.dtos;

import co.edu.udea.practicafinal.dtos.helpers.EnumRoles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  @NotBlank private String id;
  @NotBlank private String name;
  @NotBlank private String email;
  @NotBlank private String photoURL;
  @NotBlank private String phoneNumber;
  @NotBlank private EnumRoles role;

  @DateTimeFormat(style = "yyyy-MM-dd")
  private LocalDate dateOfEntry;
}
