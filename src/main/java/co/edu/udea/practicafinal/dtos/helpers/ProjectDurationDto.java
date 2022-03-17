package co.edu.udea.practicafinal.dtos.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProjectDurationDto {
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate startingDate;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate endingDate;
}
