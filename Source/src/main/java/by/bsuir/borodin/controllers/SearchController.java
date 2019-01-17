package by.bsuir.borodin.controllers;

import by.bsuir.borodin.converter.UserMapper;
import by.bsuir.borodin.security.details.UserDetailsImpl;
import by.bsuir.borodin.service.FilmService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

  private final FilmService filmService;

  private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Autowired
  public SearchController(FilmService filmService) {
    this.filmService = filmService;
  }


}
