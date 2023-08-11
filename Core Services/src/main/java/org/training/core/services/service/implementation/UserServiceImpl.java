package org.training.core.services.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.core.services.exception.ResourceNotFound;
import org.training.core.services.model.dto.UserDto;
import org.training.core.services.model.entities.User;
import org.training.core.services.model.mapper.UserMapper;
import org.training.core.services.repositories.UserRepository;
import org.training.core.services.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private UserMapper userMapper = new UserMapper();

    @Override
    public UserDto readUser(String identificationNumber) {

        User user = userRepository.findUserByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new ResourceNotFound("User with user id: " + identificationNumber + " not found"));

        return userMapper.convertToDto(user);
    }
}
