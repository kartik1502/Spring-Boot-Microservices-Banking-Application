package org.training.user.service.service;

import org.springframework.data.domain.Pageable;
import org.training.user.service.model.dto.CreateUser;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
import org.training.user.service.model.dto.response.ReadUser;
import org.training.user.service.model.dto.response.Response;

import java.util.List;

public interface UserService {

    Response createUser(CreateUser userDto);

    List<UserDto> readAllUsers();

    UserDto readUser(String  authId);

    Response updateUserStatus(Long id, UserUpdate userUpdate);

    UserDto readUserById(Long userId);
}
