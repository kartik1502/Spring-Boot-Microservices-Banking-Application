package org.training.core.services.model.mapper;

import org.springframework.beans.BeanUtils;
import org.training.core.services.model.dto.UserDto;
import org.training.core.services.model.entities.User;

import java.util.Objects;

public class UserMapper extends BaseMapper<User, UserDto> {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();

    @Override
    public User convertToEntity(UserDto dto, Object... args) {

        User user = new User();
        if(!Objects.isNull(dto)) {
            BeanUtils.copyProperties(dto, user, "bankAccountDtos");
            if(!Objects.isNull(dto.getBankAccountDtos())){
                user.setAccounts(bankAccountMapper.covertToEntityList(dto.getBankAccountDtos()));
            }
        }
        return user;
    }

    @Override
    public UserDto convertToDto(User entity, Object... args) {

        UserDto userDto = new UserDto();
        if(!Objects.isNull(entity)) {
            BeanUtils.copyProperties(entity, userDto, "accounts");
            userDto.setBankAccountDtos(bankAccountMapper.convertToDtoList(entity.getAccounts()));
        }
        return userDto;
    }
}
