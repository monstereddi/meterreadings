package org.therealmonstered.meterreadings.meters;

import org.therealmonstered.meterreadings.readings.Reading;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Meter")
@Table(name = "meter")
public class Meter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(unique = true)
  private final String name;
  private final String description;

  @OneToMany(targetEntity = Reading.class, mappedBy = "meter", fetch = FetchType.LAZY)
  private Set<Reading> readings;

  public Set<Reading> getReadings() {
    return readings;
  }

  public boolean addReading(Reading reading) {
    reading.setMeter(this);
    return readings.add(reading);
  }

  public boolean removeReading(Reading reading) {
    boolean b = readings.remove(reading);
    if (b) reading.setMeter(null);
    return b;
  }

  public Meter(long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Meter() {
    this.name = "name";
    this.description = "description";
  }

  public Meter(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "Meter{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      '}';
  }
}
