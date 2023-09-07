package org.training.account.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.training.account.service.configuration.FeignClientConfiguration;
import org.training.account.service.model.dto.external.UserDto;

@FeignClient(name = "user-service", configuration = FeignClientConfiguration.class)
public interface UserService {

    @GetMapping("/api/users/{userId}")
    ResponseEntity<UserDto> readUserById(@PathVariable Long userId);
}