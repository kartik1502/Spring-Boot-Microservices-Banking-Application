package org.training.user.service.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.training.user.service.exception.ResourceConflictException;
import org.training.user.service.model.Status;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
import org.training.user.service.model.dto.response.ReadUser;
import org.training.user.service.model.dto.response.Response;
import org.training.user.service.model.entity.User;
import org.training.user.service.model.mapper.UserMapper;
import org.training.user.service.repository.UserRepository;
import org.training.user.service.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper = new UserMapper();

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${spring.application.success}")
    private String responseCode;

    @Override
    public UserDto createUser(UserDto userDto) {

        userRepository.findUserByEmailId(userDto.getEmailId())
                .ifPresent(existingUser -> {
                    log.error("User with email id {} already exists", userDto.getEmailId());
                    throw new ResourceConflictException("User with email id " + userDto.getEmailId() + " already exists");
                });

        User newUser = userMapper.convertToEntity(userDto);
        newUser.setStatus(Status.PENDING);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User savedUser = userRepository.save(newUser);
        log.info("User with email id {} created", userDto.getEmailId());
        return userMapper.convertToDto(savedUser);

    }

    @Override
    public List<ReadUser> readAllUsers(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<UserDto> readUsers =  userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
        return readUsers.stream().map(user -> {
            ReadUser readUser = new ReadUser();
            BeanUtils.copyProperties(user, readUser);
            return readUser;
        }).collect(Collectors.toList());
    }

    @Override
    public Response updateUser(Long id, UserUpdate userUpdate) {

        userRepository.findById(id).ifPresentOrElse(existingUser -> {
            existingUser.setStatus(Status.APPROVED);
            userRepository.save(existingUser); } ,
                () -> {
                    log.error("User with id {} not found", id);
                    throw new ResourceConflictException("User with id " + id + " not found");
                }
        );
        return new Response(responseCode, "User updated successfully");
    }
}
