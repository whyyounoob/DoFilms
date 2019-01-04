package by.bsuir.borodin.service;

import by.bsuir.borodin.converter.FilmConverter;
import by.bsuir.borodin.dto.FilmDTO;
import by.bsuir.borodin.entity.Film;
import by.bsuir.borodin.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FilmService {

  private final FilmRepository filmRepository;

  @Autowired
  public FilmService(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  public List<FilmDTO> getTop100() {
    List<FilmDTO> films = new ArrayList<>();
    for (Film film : filmRepository.findTop100ByOrderByAverageRateDesc()) {
      films.add(FilmConverter.toDTO(film));
    }
    return films;
  }

  public Set<FilmDTO> getRandom() {
    Set<FilmDTO> films = new HashSet<>();
    Long count = filmRepository.count();
    while (films.size() != 2) {
      Optional<Film> film = filmRepository.getById(ThreadLocalRandom.current().nextLong(count));
      film.ifPresent(film1 -> films.add(FilmConverter.toDTO(film1)));
    }
    return films;
  }
}
