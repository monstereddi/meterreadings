package org.therealmonstered.meterreadings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.therealmonstered.meterreadings.meters.Meter;
import org.therealmonstered.meterreadings.meters.MeterRepository;
import org.therealmonstered.meterreadings.readings.Reading;
import org.therealmonstered.meterreadings.readings.ReadingRepository;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class MeterreadingsApplication {


  public static void main(String[] args) {
		SpringApplication.run(MeterreadingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(MeterRepository meterRepository, ReadingRepository readingRepository) {
    return args -> {
      meterRepository.findAll().forEach(System.out::println);
      readingRepository.findAll().forEach(System.out::println);
    };
  }
}
