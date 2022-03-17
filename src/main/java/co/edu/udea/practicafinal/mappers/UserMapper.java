package co.edu.udea.practicafinal.mappers;

import co.edu.udea.practicafinal.dtos.UserDto;
import co.edu.udea.practicafinal.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public User mapFromDtoToEntity(UserDto userDto) {
    return User.builder()
      .id(userDto.getId())
      .name(userDto.getName())
      .email(userDto.getEmail())
      .photoURL(userDto.getPhotoURL())
      .phoneNumber(userDto.getPhoneNumber())
      .role(userDto.getRole())
      .dateOfEntry(userDto.getDateOfEntry())
      .build();
  }

  public UserDto mapFromEntityToDto(User user) {
    return UserDto.builder()
      .id(user.getId())
      .name(user.getName())
      .email(user.getEmail())
      .photoURL(user.getPhotoURL())
      .phoneNumber(user.getPhoneNumber())
      .role(user.getRole())
      .dateOfEntry(user.getDateOfEntry())
      .build();
  }
}
