package by.bsuir.borodin.security.details;

import by.bsuir.borodin.entity.User;
import by.bsuir.borodin.entity.enums.State;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  private User user;

  UserDetailsImpl(User user) {
    this.user = user;
  }

  public Long getId() {
    return user.getId();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String userRole = user.getRole().name();
    SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole);
    return Collections.singletonList(grantedAuthority);
  }

  @Override
  public String getPassword() {
    return user.getHashPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.getState().equals(State.ACTIVE);
  }
}
