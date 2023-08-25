package org.training.user.service.service;

import org.springframework.data.domain.Pageable;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
import org.training.user.service.model.dto.response.ReadUser;
import org.training.user.service.model.dto.response.Response;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> readAllUsers();

    UserDto readUser(String  authId);
}
