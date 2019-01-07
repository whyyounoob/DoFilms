package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.UserDTO;
import by.bsuir.borodin.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {
  @Mappings({
    @Mapping(target = "username", source = "entity.username"),
    @Mapping(target = "id", source = "entity.id")
  })
  UserDTO userToUserDTO(User entity);

  @Mappings({
    @Mapping(target = "username", source = "dto.username"),
    @Mapping(target = "id", source = "dto.id")
  })
  User userDTOToUser(UserDTO dto);
}
