package org.training.core.services.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.core.services.exception.ResourceNotFound;
import org.training.core.services.model.dto.UtilityAccountDto;
import org.training.core.services.model.entities.UtilityAccount;
import org.training.core.services.model.mapper.UtilityAccountMapper;
import org.training.core.services.repositories.UtilityAccountRepository;
import org.training.core.services.service.UtilityAccountService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilityAccountServiceImpl implements UtilityAccountService {

    private UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();

    private final UtilityAccountRepository utilityAccountRepository;

    @Override
    public List<UtilityAccountDto> readUtilityAccount(String providerName) {

        List<UtilityAccount> utilityAccounts = utilityAccountRepository.findUtilityAccountByProviderName(providerName);
        return utilityAccountMapper.convertToDtoList(utilityAccounts);
    }

    @Override
    public UtilityAccountDto readUtilityAccount(Long utilityId) {

        UtilityAccount utilityAccount = utilityAccountRepository.findById(utilityId)
                .orElseThrow(() -> new ResourceNotFound("Utility Account with id:"+utilityId+" not found on the server"));

        return utilityAccountMapper.convertToDto(utilityAccount);
    }
}