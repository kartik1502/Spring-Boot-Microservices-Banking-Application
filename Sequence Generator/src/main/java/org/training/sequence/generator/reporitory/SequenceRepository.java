package org.training.sequence.generator.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training.sequence.generator.model.entity.Sequence;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    @Query("SELECT COUNT(s) from Sequence s")
    int countAll();

    Sequence findFirstByOrderBySequenceIdDesc();

}
