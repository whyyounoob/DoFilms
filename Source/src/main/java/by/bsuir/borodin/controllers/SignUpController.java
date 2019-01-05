package by.bsuir.borodin.controllers;

import by.bsuir.borodin.entity.UserForm;
import by.bsuir.borodin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
  private final UserService userService;

  @Autowired
  public SignUpController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/signUp")
  public String signUp() {
    return "signUp";
  }

  @PostMapping("/signUp")
  public String addUser(ModelMap model, UserForm userForm) {
    System.out.println(userForm);
    userService.saveUser(userForm);
    return "redirect:/top100";
  }
}
