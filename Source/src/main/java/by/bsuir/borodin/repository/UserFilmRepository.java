package by.bsuir.borodin.repository;

import by.bsuir.borodin.entity.User;
import by.bsuir.borodin.entity.UserFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserFilmRepository extends JpaRepository<UserFilm, Long> {
  List<UserFilm> getAllByUser(User user);

  @Query(value = "select avg(m2m_user_film.rate) as avg_rate from m2m_user_film where film_film_id = ?1", nativeQuery = true)
  Optional<BigDecimal> getAverageRate(Long id);
}
