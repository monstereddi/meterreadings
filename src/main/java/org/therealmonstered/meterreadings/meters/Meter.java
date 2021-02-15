package org.therealmonstered.meterreadings.meters;

import javax.persistence.*;

@Entity(name = "Meter")
public class Meter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(unique = true)
  private final String name;
  private final String description;

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
