package by.bsuir.borodin.repository;

import by.bsuir.borodin.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
  List<Genre> getAllByNameContains(String name);
}
