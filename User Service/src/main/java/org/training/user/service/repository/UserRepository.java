package org.training.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.user.service.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their authentication ID.
     *
     * @param  authId  the authentication ID of the user
     * @return         an optional containing the user if found, otherwise empty
     */
    Optional<User> findUserByAuthId(String authId);
}
