package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserServiceImpl implements UserService {
  @Override
  public UserDto createNewUser(UserDto userDto) {
    return null;
  }
}
