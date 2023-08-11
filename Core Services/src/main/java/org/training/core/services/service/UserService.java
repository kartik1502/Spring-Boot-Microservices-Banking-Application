package org.training.core.services.service;

import org.springframework.data.domain.Pageable;
import org.training.core.services.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto readUser(String identificationNumber);

    List<UserDto> readUsers(Pageable pageable);
}
