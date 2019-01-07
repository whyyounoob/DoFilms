package by.bsuir.borodin.controllers;

import by.bsuir.borodin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {

  private final UserService userService;

  @Autowired
  public SignInController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {
    if (authentication != null) {
      return "redirect:/";
    }
    if (request.getParameterMap().containsKey("error")) {
      model.addAttribute("error", true);
    }
    return "login";
  }
}
