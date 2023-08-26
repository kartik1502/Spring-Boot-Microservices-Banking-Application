package org.training.core.services.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.training.core.services.exception.ResourceConflict;
import org.training.core.services.exception.ResourceNotFound;
import org.training.core.services.model.dto.Response;
import org.training.core.services.model.dto.UserDto;
import org.training.core.services.model.entities.User;
import org.training.core.services.model.mapper.UserMapper;
import org.training.core.services.repositories.UserRepository;
import org.training.core.services.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private UserMapper userMapper = new UserMapper();

    @Value("${spring.application.success}")
    private String responseCodeSuccess;

    @Override
    public Response createUser(UserDto userDto) {

        User user = userRepository.findUserByIdentificationNumber(userDto.getIdentificationNumber())
                .orElseThrow(() -> new ResourceConflict("User with same emailId is already registered"));

        userRepository.save(userMapper.convertToEntity(userDto));
        return Response.builder()
                .responseMessage("User Registered successfully")
                .responseCode(responseCodeSuccess).build();
    }

    @Override
    public UserDto readUser(String identificationNumber) {

        User user = userRepository.findUserByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new ResourceNotFound("User with user id: " + identificationNumber + " not found"));

        return userMapper.convertToDto(user);
    }

    @Override
    public List<UserDto> readUsers(Pageable pageable) {

        return userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }
}
