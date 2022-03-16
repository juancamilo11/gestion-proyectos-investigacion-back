package co.edu.udea.practicafinal.services;

import co.edu.udea.practicafinal.dtos.UserDto;

public interface UserService {
  UserDto createNewUser(final UserDto userDto);
}
