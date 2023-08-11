package org.training.core.services.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.core.services.service.UtilityAccountService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/utility-accounts")
public class UtilityAccountController {

    private final UtilityAccountService utilityAccountService;

    @GetMapping("/{providerNumber}")
    public ResponseEntity readUtilityAccount(@PathVariable String providerNumber){
        return ResponseEntity.ok(utilityAccountService.readUtilityAccount(providerNumber));
    }
}
