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

    /**
     * Create a new account number.
     *
     * @return The newly created account number.
     */
    @Override
    public Sequence create() {

        log.info("creating a account number");
        return sequenceRepository.findById(1L)
                .map(sequence -> {
                    sequence.setAccountNumber(sequence.getAccountNumber() + 1);
                    return sequenceRepository.save(sequence);
                }).orElseGet(() -> sequenceRepository.save(Sequence.builder().accountNumber(1L).build()));
    }
}
