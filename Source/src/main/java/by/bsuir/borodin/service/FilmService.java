package by.bsuir.borodin.service;

import by.bsuir.borodin.converter.FilmConverter;
import by.bsuir.borodin.dto.FilmDTO;
import by.bsuir.borodin.dto.UserFilmDTO;
import by.bsuir.borodin.entity.Film;
import by.bsuir.borodin.entity.User;
import by.bsuir.borodin.entity.UserFilm;
import by.bsuir.borodin.entity.UserFilmId;
import by.bsuir.borodin.repository.FilmRepository;
import by.bsuir.borodin.repository.GenreRepository;
import by.bsuir.borodin.repository.UserFilmRepository;
import by.bsuir.borodin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional(rollbackFor = Exception.class)
public class FilmService {

  private final UserRepository userRepository;

  private final UserFilmRepository userFilmRepository;

  private final FilmRepository filmRepository;

  @Autowired
  private GenreRepository

  @Autowired
  public FilmService(
      FilmRepository filmRepository,
      UserRepository userRepository,
      UserFilmRepository userFilmRepository) {
    this.filmRepository = filmRepository;
    this.userRepository = userRepository;
    this.userFilmRepository = userFilmRepository;
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

  public FilmDTO getById(Long id) {
    return filmRepository.getById(id).map(FilmConverter::toDTO).orElse(null);
  }

  public List<UserFilmDTO> getByUser(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      List<UserFilm> films = userFilmRepository.getAllByUser(user.get());
      List<UserFilmDTO> retFilms = new ArrayList<>();
      for (UserFilm userFilm : films) {
        UserFilmDTO userFilmDTO = new UserFilmDTO();
        userFilmDTO.setRate(userFilm.getRate());
        userFilmDTO.setFilm(FilmConverter.toDTO(userFilm.getFilm()));
        retFilms.add(userFilmDTO);
      }
      return retFilms;
    }
    return null;
  }

  public void addFilm(Long filmId, Long userId, int rate) {
    Optional<User> user = userRepository.findById(userId);
    Optional<Film> film = filmRepository.getById(filmId);
    if (user.isPresent() && film.isPresent()) {
      UserFilm userFilm =
          UserFilm.builder()
              .film(film.get())
              .user(user.get())
              .rate(rate)
              .id(UserFilmId.builder().filmId(filmId).userId(userId).build())
              .build();
      userFilmRepository.save(userFilm);
      Optional<BigDecimal> avgRate = userFilmRepository.getAverageRate(film.get().getId());
      avgRate.ifPresent(
          bigDecimal ->
              filmRepository.updateAverageRate(film.get().getId(), bigDecimal.doubleValue()));
    }
  }

  public List<FilmDTO> findByName(String name) {
    List<Film> films = filmRepository.getAllByTitleContains(name);
    List<FilmDTO> dtos = new ArrayList<>();
    for (Film film : films) {
      dtos.add(FilmConverter.toDTO(film));
    }
    return dtos;
  }

  public List<FilmDTO> findByGenre(String genre) {
    return null;
  }

  public void addSchedule(Long userId, Long filmId) {
    Optional<User> user = userRepository.findById(userId);
    Optional<Film> film = filmRepository.getById(filmId);
    if (user.isPresent() && film.isPresent()) {
      UserFilm userFilm =
          UserFilm.builder()
              .film(film.get())
              .user(user.get())
              .id(UserFilmId.builder().filmId(filmId).userId(userId).build())
              .build();
      userFilmRepository.save(userFilm);
    }
  }

  public List<FilmDTO> getSchedule(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      List<UserFilm> films = userFilmRepository.getAllByUser(user.get());
      List<FilmDTO> retFilms = new ArrayList<>();
      for (UserFilm userFilm : films) {
        if (userFilm.getRate() == 0) {
          retFilms.add(FilmConverter.toDTO(userFilm.getFilm()));
        }
      }
      return retFilms;
    }
    return new ArrayList<>();
  }
}
