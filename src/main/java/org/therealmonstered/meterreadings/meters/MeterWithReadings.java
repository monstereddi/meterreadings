package org.therealmonstered.meterreadings.meters;

import java.util.Date;

public class MeterWithReadings {
  private long meter_id;
  private String name;
  private String description;
  private long reading_id;
  private Date date;
  private double reading_value;

  public MeterWithReadings(long meter_id, String name, String description, long reading_id, Date date, double reading_value) {
    this.meter_id = meter_id;
    this.name = name;
    this.description = description;
    this.reading_id = reading_id;
    this.date = date;
    this.reading_value = reading_value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getReading_value() {
    return reading_value;
  }

  public void setReading_value(double reading_value) {
    this.reading_value = reading_value;
  }

  @Override
  public String toString() {
    return "MeterWithReadings{" +
      "meter_id=" + meter_id +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", reading_id=" + reading_id +
      ", date=" + date +
      ", reading_value=" + reading_value +
      '}';
  }
}
