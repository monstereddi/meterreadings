package org.therealmonstered.meterreadings.meters;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  MeterRepository extends CrudRepository<Meter, Long> {

  Optional<Meter> findMeterById(Long id);
}
