package org.training.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.training.user.service.model.dto.external.UserCreate;
import org.training.user.service.model.dto.response.Response;

@FeignClient(name = "core-services")
public interface CoreService {

    @PostMapping("/core-services/users")
    ResponseEntity<Response> createUser(UserCreate userCreate);

}
