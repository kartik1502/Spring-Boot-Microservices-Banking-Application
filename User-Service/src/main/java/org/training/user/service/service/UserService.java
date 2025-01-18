package org.training.user.service.service;

import org.training.user.service.model.dto.CreateUser;
import org.training.user.service.model.dto.UserDto;
import org.training.user.service.model.dto.UserUpdate;
import org.training.user.service.model.dto.UserUpdateStatus;
import org.training.user.service.model.dto.response.Response;

import java.util.List;

public interface UserService {

    /**
     * Creates a new user.
     *
     * @param  userDto  the user DTO containing user information
     * @return          the response indicating the success or failure of the user creation
     */
    Response createUser(CreateUser userDto);

    /**
     * Retrieves a list of all users.
     *
     * @return          a list of UserDto objects representing all users
     */
    List<UserDto> readAllUsers();

    /**
     * Reads a user from the specified authentication ID.
     *
     * @param  authId  the authentication ID of the user
     * @return         the UserDto object representing the user
     */
    UserDto readUser(String authId);

    /**
     * Updates the status of a user.
     *
     * @param  id           the ID of the user
     * @param  userUpdate   the updated status of the user
     * @return              the response object indicating the success or failure of the operation
     */
    Response updateUserStatus(Long id, UserUpdateStatus userUpdate);

    /**
     * Updates a user.
     *
     * @param  id         the ID of the user to be updated
     * @param  userUpdate the updated user information
     * @return            the response indicating the success or failure of the update operation
     */
    Response updateUser(Long id, UserUpdate userUpdate);

    /**
     * Reads a user by their ID.
     *
     * @param  userId  the ID of the user to be read
     * @return         a UserDto object representing the user with the given ID
     */
    UserDto readUserById(Long userId);

    /**
     * Reads a user by their account ID.
     *
     * @param  accountId  the account ID of the user
     * @return            the UserDto object representing the user with the specified account ID
     */
    UserDto readUserByAccountId(String accountId);
}
