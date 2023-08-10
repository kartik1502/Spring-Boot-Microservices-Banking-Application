package org.training.core.services.model.mapper;

import org.springframework.beans.BeanUtils;
import org.training.core.services.model.dto.UtilityAccountDto;
import org.training.core.services.model.entities.UtilityAccount;

import java.util.Objects;

public class UtilityAccountMapper extends BaseMapper<UtilityAccount, UtilityAccountDto> {

    @Override
    public UtilityAccount convertToEntity(UtilityAccountDto dto, Object... args) {

        UtilityAccount utilityAccount = new UtilityAccount();
        if(!Objects.isNull(dto)) {
            BeanUtils.copyProperties(dto, utilityAccount);
        }
        return utilityAccount;
    }

    @Override
    public UtilityAccountDto convertToDto(UtilityAccount entity, Object... args) {

        UtilityAccountDto utilityAccountDto = new UtilityAccountDto();
        if(!Objects.isNull(entity)) {
            BeanUtils.copyProperties(entity, utilityAccountDto);
        }
        return utilityAccountDto;
    }
}
