package by.bsuir.borodin.repository;

import by.bsuir.borodin.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
  List<Film> findTop100ByOrderByAverageRateDesc();
  Optional<Film> getById(Long id);
  @Modifying
  @Query(value = "UPDATE films SET average_rate = ?2 WHERE (`film_id` = ?1)", nativeQuery = true)
  void updateAverageRate(long bookId, double rate);
  List<Film> getAllByTitleContains(String title);
}
