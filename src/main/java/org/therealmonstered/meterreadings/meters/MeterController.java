package org.therealmonstered.meterreadings.meters;

import org.springframework.web.bind.annotation.*;
import org.therealmonstered.meterreadings.exceptions.MeterNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MeterController {

  private final MeterRepository meterRepository;

  public MeterController(MeterRepository meterRepository) {
    this.meterRepository = meterRepository;
  }

  @GetMapping("/meters")
  public List<Meter> getMeters() {
    return (List<Meter>) meterRepository.findAll();
  }

  @GetMapping("/meters/{id}")
  public Meter getMeterById(@PathVariable Long id) throws Throwable {
    return (Meter) meterRepository.findMeterById(id).orElseThrow(
      () -> new MeterNotFoundException("Meter with id = " + id + " not found."));
  }

  @PostMapping("meters/add")
  public void addMeter(@RequestBody Meter meter) {
    meterRepository.save(meter);
  }

  @DeleteMapping("/meters/delete/{id}")
  public void deleteMeter(@PathVariable Long id) {
    meterRepository.deleteById(id);
  }

}
