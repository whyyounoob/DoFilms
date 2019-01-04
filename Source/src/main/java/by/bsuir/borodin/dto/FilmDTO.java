package by.bsuir.borodin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {
  private Long id;
  private String title;
  private String year;
  private Double averageRate;
  private String genres;
  private String stars;
  private String directors;
}
