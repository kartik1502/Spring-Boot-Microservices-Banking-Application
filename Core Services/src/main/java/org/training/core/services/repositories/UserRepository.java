package org.training.core.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.core.services.model.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByIdentificationNumber(String identificationNumber);
}
