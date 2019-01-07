package by.bsuir.borodin.controllers;

import by.bsuir.borodin.converter.UserMapper;
import by.bsuir.borodin.dto.FilmDTO;
import by.bsuir.borodin.security.details.UserDetailsImpl;
import by.bsuir.borodin.service.FilmService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
public class FilmController {

  private FilmService filmService;

  private FilmDTO lastFilm;

  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Autowired
  public FilmController(FilmService filmService) {
    this.filmService = filmService;
  }

  @GetMapping("/top100")
  public String getTop100(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
    }
    List<FilmDTO> films = filmService.getTop100();
    model.addAttribute("filmsFromServer", films);
    return "main";
  }

  @GetMapping("/random")
  public String random(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
    }
    Set<FilmDTO> films = filmService.getRandom();
    model.addAttribute("filmsFromServer", films);
    return "main";
  }

  @GetMapping("/{id}")
  public String getOne(
      ModelMap model, @PathVariable(value = "id") long filmId, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
    }
    FilmDTO film = filmService.getById(filmId);
    lastFilm = film;
    model.addAttribute("filmFromServer", film);
    return "film";
  }

  @GetMapping("/lastFilm")
  public String lastFilm(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
    }
    if (lastFilm != null) {
      model.addAttribute("filmFromServer", lastFilm);
    } else {
      model.addAttribute("filmFromServer", filmService.getById(1L));
    }
    return "film";
  }
}
