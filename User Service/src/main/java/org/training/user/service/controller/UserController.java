package org.training.user.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
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

    @GetMapping
    public ResponseEntity readAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
      return ResponseEntity.ok(userService.readAllUsers(page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, UserUpdate userUpdate) {
      return ResponseEntity.ok(userService.updateUser(id, userUpdate));
    }
}
