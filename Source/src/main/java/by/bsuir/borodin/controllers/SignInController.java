package by.bsuir.borodin.controllers;

import by.bsuir.borodin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

  private final UserService userService;

  @Autowired
  public SignInController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/logIn")
  public String getLogIn() {
    return "signIn";
  }
}
