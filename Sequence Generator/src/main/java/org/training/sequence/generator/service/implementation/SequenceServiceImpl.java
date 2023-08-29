package org.training.sequence.generator.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.training.sequence.generator.model.entity.Sequence;
import org.training.sequence.generator.reporitory.SequenceRepository;
import org.training.sequence.generator.service.SequenceService;

@Slf4j
@Service
@RequiredArgsConstructor
public class SequenceServiceImpl implements SequenceService {

    private final SequenceRepository sequenceRepository;

    @Override
    public Sequence create() {

        log.info("creating a account number");
        if(sequenceRepository.countAll() == 0) {
            sequenceRepository.save(Sequence.builder()
                    .accountNumber(1L).build());
        }
        Sequence sequence = sequenceRepository.findFirstByOrderBySequenceIdDesc();
        return sequenceRepository.save(Sequence.builder().accountNumber(sequence.getAccountNumber()+1).build());
    }
}
