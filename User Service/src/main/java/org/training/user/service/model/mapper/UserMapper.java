package org.training.user.service.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserProfileDto;
import org.training.user.service.model.entity.User;
import org.training.user.service.model.entity.UserProfile;

import java.util.Objects;

public class UserMapper extends BaseMapper<User, UserDto>{

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public User convertToEntity(UserDto dto, Object... args) {

        User user = new User();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, user);
            if(!Objects.isNull(dto.getUserProfileDto())){
                UserProfile userProfile = new UserProfile();
                BeanUtils.copyProperties(dto.getUserProfileDto(), userProfile);
                user.setUserProfile(userProfile);
            }
        }
        return user;
    }

    @Override
    public UserDto convertToDto(User entity, Object... args) {

        UserDto userDto = new UserDto();
        if(!Objects.isNull(entity)){
            BeanUtils.copyProperties(entity, userDto);
            if(!Objects.isNull(entity.getUserProfile())) {
                UserProfileDto userProfileDto = new UserProfileDto();
                BeanUtils.copyProperties(entity.getUserProfile(), userProfileDto);
                userDto.setUserProfileDto(userProfileDto);
            }
        }
        return userDto;
    }
}
