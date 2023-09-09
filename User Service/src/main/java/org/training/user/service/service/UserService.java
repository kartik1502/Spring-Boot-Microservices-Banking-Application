package org.training.user.service.service;

import org.training.user.service.model.dto.CreateUser;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
import org.training.user.service.model.dto.UserUpdateStatus;
import org.training.user.service.model.dto.response.Response;

import java.util.List;

public interface UserService {

    Response createUser(CreateUser userDto);

    List<UserDto> readAllUsers();

    UserDto readUser(String  authId);

    Response updateUserStatus(Long id, UserUpdateStatus userUpdate);

    Response updateUser(Long id, UserUpdate userUpdate);

    UserDto readUserById(Long userId);
}
