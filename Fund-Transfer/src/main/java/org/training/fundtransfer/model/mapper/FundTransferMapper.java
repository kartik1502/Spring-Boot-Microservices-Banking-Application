package org.training.fundtransfer.model.mapper;

import org.springframework.beans.BeanUtils;
import org.training.fundtransfer.model.dto.FundTransferDto;
import org.training.fundtransfer.model.entity.FundTransfer;

import java.util.Objects;

public class FundTransferMapper extends BaseMapper<FundTransfer, FundTransferDto> {

    /**
     * Converts a FundTransferDto object to a FundTransfer entity.
     *
     * @param  dto   the FundTransferDto object to be converted
     * @param  args  additional arguments (not used in this function)
     * @return       the converted FundTransfer entity
     */
    @Override
    public FundTransfer convertToEntity(FundTransferDto dto, Object... args) {

        FundTransfer fundTransfer = new FundTransfer();
        if(!Objects.isNull(dto)){
            BeanUtils.copyProperties(dto, fundTransfer);
        }
        return fundTransfer;
    }

    /**
     * Converts the given FundTransfer entity to a FundTransferDto object.
     *
     * @param  entity  the FundTransfer entity to be converted
     * @param  args    additional arguments (optional)
     * @return         the converted FundTransferDto object
     */
    @Override
    public FundTransferDto convertToDto(FundTransfer entity, Object... args) {

        FundTransferDto fundTransferDto = new FundTransferDto();
        if(!Objects.isNull(entity)){
            BeanUtils.copyProperties(entity, fundTransferDto);
        }
        return fundTransferDto;
    }
}
