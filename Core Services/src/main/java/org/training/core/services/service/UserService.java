package org.training.core.services.service;

import org.training.core.services.model.dto.UserDto;

public interface UserService {

    UserDto readUser(String identificationNumber);
}
