package org.training.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.user.service.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailId(String emailId);
}
