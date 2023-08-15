package org.training.user.service.service;

import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.response.ReadUser;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<ReadUser> readAllUsers();
}
