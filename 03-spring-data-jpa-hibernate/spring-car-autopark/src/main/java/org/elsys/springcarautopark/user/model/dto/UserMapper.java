package org.elsys.springcarautopark.user.model.dto;

import org.elsys.springcarautopark.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User fromDto(UserDto userDto);

}
