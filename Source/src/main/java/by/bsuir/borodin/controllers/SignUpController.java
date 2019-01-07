package by.bsuir.borodin.controllers;

import by.bsuir.borodin.entity.UserForm;
import by.bsuir.borodin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public SignUpController(UserService userService, PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping("/signUp")
  public String signUp() {
    return "signUp";
  }

  @PostMapping("/signUp")
  public String addUser(ModelMap model, UserForm userForm) {
    if (!userService.checkUsername(userForm.getUsername())) {
      model.addAttribute("errorUsername", true);
      return "signUp";
    }
    if (!userService.checkEmail(userForm.getEmail())) {
      model.addAttribute("errorEmail", true);
      return "signUp";
    }
    if (!userForm.getPassword().equals(userForm.getConfirm())) {
      model.addAttribute("errorPassword", true);
      return "signUp";
    }
    userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
    userService.saveUser(userForm);
    return "redirect:/top100";
  }
}
