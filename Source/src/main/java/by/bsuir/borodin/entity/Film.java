package by.bsuir.borodin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "films")
public class Film {

    @Id
    @Column(name = "film_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "average_rate")
    private Double averageRate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "m2m_film_genre",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "m2m_film_director",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id")})
    private List<Director> directors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "m2m_film_star",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "star_id")})
    private List<Star> stars;

    @OneToMany(mappedBy = "film", orphanRemoval = true)
    private List<UserFilm> users;
}
