package org.training.user.service.model.mapper;

import org.springframework.beans.BeanUtils;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.entity.User;

import java.util.Objects;

public class UserMapper extends BaseMapper<User, UserDto>{

    @Override
    public User convertToEntity(UserDto dto, Object... args) {

        User user = new User();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, user);
        }
        return user;
    }

    @Override
    public UserDto convertToDto(User entity, Object... args) {

        UserDto userDto = new UserDto();
        if(!Objects.isNull(entity)){
            BeanUtils.copyProperties(entity, userDto);
        }
        return userDto;
    }
}
