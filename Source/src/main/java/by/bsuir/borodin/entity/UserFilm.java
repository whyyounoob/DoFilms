package by.bsuir.borodin.entity;

import lombok.*;

import javax.persistence.*;

@ToString(exclude = {"user", "film"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "m2m_user_film")
public class UserFilm {

    @EmbeddedId
    private UserFilmId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmId")
    private Film film;

    @Column(name = "rate")
    private int rate;
}