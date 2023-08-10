package org.training.core.services.model.mapper;

import org.springframework.beans.BeanUtils;
import org.training.core.services.model.dto.BankAccountDto;
import org.training.core.services.model.entities.BankAccount;

import java.util.Objects;

public class BankAccountMapper extends BaseMapper<BankAccount, BankAccountDto> {

    @Override
    public BankAccount convertToEntity(BankAccountDto dto, Object... args) {
        BankAccount bankAccount = new BankAccount();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, bankAccount, "userDto");
        }
        return bankAccount;
    }

    @Override
    public BankAccountDto convertToDto(BankAccount entity, Object... args) {

        BankAccountDto bankAccountDto = new BankAccountDto();
        if(!Objects.isNull(bankAccountDto)){
            BeanUtils.copyProperties(entity, bankAccountDto, "user");
        }
        return bankAccountDto;
    }
}
