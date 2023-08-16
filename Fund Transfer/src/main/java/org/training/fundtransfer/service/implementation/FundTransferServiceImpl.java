package org.training.fundtransfer.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.training.fundtransfer.mapper.FundTransferMapper;
import org.training.fundtransfer.model.TransactionStatus;
import org.training.fundtransfer.model.dto.FundTransferDto;
import org.training.fundtransfer.model.dto.request.FundTransferRequest;
import org.training.fundtransfer.model.dto.request.response.FundTransferResponse;
import org.training.fundtransfer.model.entity.FundTransfer;
import org.training.fundtransfer.repository.FundTransferRepository;
import org.training.fundtransfer.service.FundTransferService;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FundTransferServiceImpl implements FundTransferService {

    private final FundTransferRepository fundTransferRepository;

    private FundTransferMapper fundTransferMapper = new FundTransferMapper();

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {

        log.info("Fund Transfer Request: {}", fundTransferRequest);

        FundTransfer fundTransfer = new FundTransfer();
        BeanUtils.copyProperties(fundTransferRequest, fundTransfer);
        fundTransfer.setStatus(TransactionStatus.PENDING);

        fundTransferRepository.save(fundTransfer);

        return FundTransferResponse.builder()
                .message("Fund Transfer Successful")
                .transactionId(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public List<FundTransferDto> readAllTransfers(int page, int size) {

        return fundTransferMapper.convertToDtoList(
                fundTransferRepository.findAll(PageRequest.of(page, size)).getContent());
    }


}
