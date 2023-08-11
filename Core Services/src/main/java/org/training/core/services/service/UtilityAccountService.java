package org.training.core.services.service;

import org.training.core.services.model.dto.UtilityAccountDto;

import java.util.List;

public interface UtilityAccountService {

    List<UtilityAccountDto> readUtilityAccount(String providerName);
}
