package org.therealmonstered.meterreadings.meters;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  MeterRepository extends CrudRepository<Meter, Long> {

  @Override
  @Query("SELECT new Meter(id, name, description) FROM Meter")
  Iterable<Meter> findAll();

  @Query("SELECT new Meter(m.id, m.name, m.description) FROM Meter as m where m.id=?1")
  Optional<Meter> findMeterById(Long id);

  @Query("SELECT new org.therealmonstered.meterreadings.meters.MeterWithReadings(m.id, m.name, m.description, r.id, r.date, r.reading_value) FROM Meter as m JOIN m.readings as r")
  List<MeterWithReadings> fetchMetersWithReadings();
}
