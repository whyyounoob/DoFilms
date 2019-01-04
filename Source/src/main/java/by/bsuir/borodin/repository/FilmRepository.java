package by.bsuir.borodin.repository;

import by.bsuir.borodin.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
  List<Film> findTop100ByOrderByAverageRateDesc();
  Optional<Film> getById(Long id);
}
