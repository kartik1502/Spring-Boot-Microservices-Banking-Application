package org.training.core.services.service;

import org.springframework.data.domain.Pageable;
import org.training.core.services.model.dto.Response;
import org.training.core.services.model.dto.UserDto;

import java.util.List;

public interface UserService {

    Response createUser(UserDto userDto);
    UserDto readUser(String identificationNumber);

    List<UserDto> readUsers(Pageable pageable);
}
