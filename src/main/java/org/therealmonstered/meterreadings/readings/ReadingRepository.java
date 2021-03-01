package org.therealmonstered.meterreadings.readings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReadingRepository extends CrudRepository<Reading, Long> {

  @Override
  Optional<Reading> findById(Long aLong);
}
