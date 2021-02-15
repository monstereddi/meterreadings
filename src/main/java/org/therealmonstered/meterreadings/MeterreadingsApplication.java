package org.therealmonstered.meterreadings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.therealmonstered.meterreadings.meters.Meter;
import org.therealmonstered.meterreadings.meters.MeterRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class MeterreadingsApplication {


  public static void main(String[] args) {
		SpringApplication.run(MeterreadingsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MeterRepository meterRepository) {
    return args -> {
//      Stream.of("Strom", "Wasser", "Heizöl", "Auto").forEach(name -> {
//        Meter meter = new Meter(name, "Zähler für "+ name);
//        meterRepository.save(meter);
//      });
      meterRepository.findAll().forEach(System.out::println);
    };
  }
}
