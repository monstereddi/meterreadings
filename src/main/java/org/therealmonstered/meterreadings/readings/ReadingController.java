package org.therealmonstered.meterreadings.readings;

import org.springframework.web.bind.annotation.*;
import org.therealmonstered.meterreadings.exceptions.ReadingNotFoundException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReadingController {

  private ReadingRepository readingRepository;

  public ReadingController(ReadingRepository readingRepository) {
    this.readingRepository = readingRepository;
  }

  @GetMapping("/readings")
  public List<Reading> getReadings() {
    return (List<Reading>) this.readingRepository.findAll();
  }

  @GetMapping("/readings/{id}")
  public Reading getReading(@PathVariable Long id) {
    return (Reading) this.readingRepository.findById(id).orElseThrow(
      () -> new ReadingNotFoundException("Reading with " + id + " not found."));
  }

  @PostMapping("/readings/add")
  public void addReading(@PathVariable Reading reading) {
    this.readingRepository.save(reading);
  }

  @PostMapping("readings/delete/{id}")
  public void deleteReading(@PathVariable Long id) {
    this.readingRepository.deleteById(id);
  }

}
