package org.training.user.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.user.service.model.dto.CreateUser;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
import org.training.user.service.model.dto.UserUpdateStatus;
import org.training.user.service.model.dto.response.Response;
import org.training.user.service.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Creates a new user.
     *
     * @param userDto the user data transfer object
     * @return the response entity containing the response
     */
    @PostMapping("/register")
    public ResponseEntity<Response> createUser(@RequestBody CreateUser userDto) {
        log.info("creating user with: {}", userDto.toString());
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    /**
     * Retrieves all users.
     *
     * @return The list of user DTOs
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> readAllUsers() {
        return ResponseEntity.ok(userService.readAllUsers());
    }

    /**
     * Retrieves a user by their authentication ID.
     *
     * @param authId The authentication ID of the user.
     * @return The response entity containing the user DTO.
     */
    @GetMapping("auth/{authId}")
    public ResponseEntity<UserDto> readUserByAuthId(@PathVariable String authId) {
        log.info("reading user by authId");
        return ResponseEntity.ok(userService.readUser(authId));
    }

    /**
     * Updates the status of a user.
     *
     * @param id The ID of the user to update.
     * @param userUpdate The updated status of the user.
     * @return The response entity containing the updated user and HTTP status.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Response> updateUserStatus(@PathVariable Long id, @RequestBody UserUpdateStatus userUpdate) {
        log.info("updating the user with: {}", userUpdate.toString());
        return new ResponseEntity<>(userService.updateUserStatus(id, userUpdate), HttpStatus.OK);
    }

    /**
     * Updates a user with the given ID.
     *
     * @param id The ID of the user to update.
     * @param userUpdate The updated user information.
     * @return The response with the updated user information.
     */
    @PutMapping("{id}")
    public ResponseEntity<Response> updateUser(@PathVariable Long id, @RequestBody UserUpdate userUpdate) {
        return new ResponseEntity<>(userService.updateUser(id, userUpdate), HttpStatus.OK);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the user details as a ResponseEntity
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> readUserById(@PathVariable Long userId) {
        log.info("reading user by ID");
        return ResponseEntity.ok(userService.readUserById(userId));
    }

    /**
     * Retrieves the user with the specified account ID.
     *
     * @param accountId The account ID of the user to retrieve.
     * @return The user DTO associated with the account ID.
     */
    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<UserDto> readUserByAccountId(@PathVariable String accountId) {
        return ResponseEntity.ok(userService.readUserByAccountId(accountId));
    }
}
