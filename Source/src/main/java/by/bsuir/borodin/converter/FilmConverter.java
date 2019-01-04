package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.FilmDTO;
import by.bsuir.borodin.entity.Director;
import by.bsuir.borodin.entity.Film;
import by.bsuir.borodin.entity.Genre;
import by.bsuir.borodin.entity.Star;

public class FilmConverter {
  public static FilmDTO toDTO(Film film) {
    FilmDTO filmDTO = new FilmDTO();
    filmDTO.setId(film.getId());
    filmDTO.setTitle(film.getTitle());
    filmDTO.setYear(String.valueOf(film.getYear()));
    filmDTO.setAverageRate(film.getAverageRate());
    String genres = new String();
    for (Genre genre : film.getGenres()) {
      genres += (genre.getName() + ", ");
    }
    genres = genres.substring(0, genres.length() - 2);
    filmDTO.setGenres(genres);
    String directors = new String();
    for (Director director : film.getDirectors()) {
      directors += (director.getName() + ", ");
    }
    directors = directors.substring(0, directors.length() - 2);
    filmDTO.setDirectors(directors);
    String stars = new String();
    for (Star star : film.getStars()) {
      stars += (star.getName() + ", ");
    }
    stars = stars.substring(0, stars.length() - 2);
    filmDTO.setStars(stars);
    return filmDTO;
  }
}
