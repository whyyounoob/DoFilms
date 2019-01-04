package by.bsuir.borodin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserFilmId implements Serializable {
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "film_id")
  private Long filmId;
}
