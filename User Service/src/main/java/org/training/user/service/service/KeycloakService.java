package org.training.user.service.service;

import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface KeycloakService {

    /**
     * Creates a new user with the provided user representation.
     *
     * @param  userRepresentation  the user representation object containing the user details
     * @return                     the ID of the newly created user
     */
    Integer createUser(UserRepresentation userRepresentation);

    /**
     * Retrieves a list of user representations based on the provided email ID.
     *
     * @param  emailId  the email ID of the user(s) to retrieve
     * @return          a list of user representations matching the provided email ID
     */
    List<UserRepresentation> readUserByEmail(String emailId);

    /**
     * Retrieves a list of user representations based on the provided authentication IDs.
     *
     * @param  authIds  a list of authentication IDs used to identify the users
     * @return          a list of user representations
     */
    List<UserRepresentation> readUsers(List<String> authIds);

    /**
     * Reads a user representation based on the provided authentication ID.
     *
     * @param  authId the authentication ID of the user
     * @return        the user representation
     */
    UserRepresentation readUser(String authId);

    /**
     * Updates the user with the provided user representation.
     *
     * @param  userRepresentation  the user representation object containing the updated user details
     */
    void updateUser(UserRepresentation userRepresentation);
}
