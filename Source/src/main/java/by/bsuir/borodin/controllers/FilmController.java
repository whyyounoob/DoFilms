package by.bsuir.borodin.controllers;

import by.bsuir.borodin.converter.UserMapper;
import by.bsuir.borodin.dto.FilmDTO;
import by.bsuir.borodin.dto.UserFilmDTO;
import by.bsuir.borodin.entity.UserFilm;
import by.bsuir.borodin.security.details.UserDetailsImpl;
import by.bsuir.borodin.service.FilmService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
      FilmDTO film = filmService.getById(filmId);
      lastFilm = film;
      model.addAttribute("filmFromServer", film);
      for (UserFilm userFilm : userDetails.getUser().getFilms()) {
        if (userFilm.getFilm().getId().equals(filmId)) {
          model.addAttribute("rate", userFilm.getRate());
        }
      }
    }
    return "film";
  }

  @PostMapping("/add")
  public String addFilmId(
      ModelMap model, @RequestParam String yourRate, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
      filmService.addFilm(lastFilm.getId(), userDetails.getId(), Integer.parseInt(yourRate));
    }
    return "redirect:/myFilms";
  }

  @GetMapping("/lastFilm")
  public String lastFilm(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
      if (lastFilm != null) {
        model.addAttribute("filmFromServer", lastFilm);
      } else {
        model.addAttribute("filmFromServer", filmService.getById(1L));
        lastFilm = filmService.getById(1L);
      }
      for (UserFilm userFilm : userDetails.getUser().getFilms()) {
        if (userFilm.getFilm().getId().equals(lastFilm.getId())) {
          model.addAttribute("rate", userFilm.getRate());
        }
      }
    }
    return "film";
  }

  @GetMapping("/myFilms")
  public String myFilms(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
      List<UserFilmDTO> films = filmService.getByUser(userDetails.getId());
      model.addAttribute("filmsFromServer", films);

      return "myFilms";
    }
    return "redirect:/top100";
  }

  @PostMapping("/search")
  public String search(
      @RequestParam String search,
      @RequestParam String searchType,
      ModelMap model,
      Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
      if (searchType.equals("name")) {
        List<FilmDTO> films = filmService.findByName(search);
        model.addAttribute("filmsFromServer", films);
      } else {
        filmService.findByGenre(search);
      }
    }
    return "main";
  }

  @PostMapping("/addSchedule")
  public String addSchedule(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
      filmService.addSchedule(userDetails.getId(), lastFilm.getId());
    }
    return "redirect:/schedule";
  }

  @GetMapping("/schedule")
  public String schedule(ModelMap model, Authentication authentication) {
    if (authentication != null) {
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      model.addAttribute("userDto", userMapper.userToUserDTO(userDetails.getUser()));
      List<FilmDTO> films = filmService.getSchedule(userDetails.getId());
      model.addAttribute("filmsFromServer", films);
    }
    return "main";
  }
}
