package org.training.account.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.training.account.service.configuration.FeignClientConfiguration;
import org.training.account.service.model.dto.external.UserDto;

@FeignClient(name = "user-service", configuration = FeignClientConfiguration.class)
public interface UserService {

    /**
     * Retrieves a user by their ID.
     *
     * @param userId the ID of the user to retrieve
     * @return a ResponseEntity containing the user DTO if found, or an empty body with a not found status code
     */
    @GetMapping("/api/users/{userId}")
    ResponseEntity<UserDto> readUserById(@PathVariable Long userId);
}