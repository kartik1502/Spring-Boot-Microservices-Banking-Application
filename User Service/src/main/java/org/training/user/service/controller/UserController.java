package org.training.user.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
      log.info("Creating user with {}", userDto.toString());
      return ResponseEntity.ok(userService.createUser(userDto));
    }
}
