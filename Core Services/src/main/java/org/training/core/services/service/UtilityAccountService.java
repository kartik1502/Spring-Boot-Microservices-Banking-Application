package org.training.core.services.service;

import org.training.core.services.model.dto.UtilityAccountDto;
import org.training.core.services.model.entities.UtilityAccount;

import java.util.List;

public interface UtilityAccountService {

    List<UtilityAccountDto> readUtilityAccount(String providerName);

    UtilityAccountDto readUtilityAccount(Long utilityId);
}
