package by.bsuir.borodin.service;

import by.bsuir.borodin.entity.User;
import by.bsuir.borodin.entity.UserForm;
import by.bsuir.borodin.entity.enums.Role;
import by.bsuir.borodin.entity.enums.State;
import by.bsuir.borodin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(UserForm userForm) {
    User user =
        User.builder()
            .hashPassword(userForm.getPassword())
            .username(userForm.getUsername())
            .role(Role.USER)
            .state(State.ACTIVE)
            .email(userForm.getEmail())
            .build();
    userRepository.save(user);
  }
}
