package org.training.account.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.training.account.service.model.dto.external.SequenceDto;

@FeignClient(name = "sequence-generator")
public interface SequenceService {

    @PostMapping("/sequence")
    SequenceDto generateAccountNumber();
}
