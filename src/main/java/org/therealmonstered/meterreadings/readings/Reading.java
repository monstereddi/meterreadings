package org.therealmonstered.meterreadings.readings;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.therealmonstered.meterreadings.meters.Meter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Readings")
@Table(name = "readings")
public class Reading {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Date date;
  @Column(name = "value")
  private double reading_value;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "meter_id")
  @Fetch(FetchMode.JOIN)
  private Meter meter;

  public Reading(long id, Date date, double reading_value, Meter meter) {
    this.id = id;
    this.date = date;
    this.reading_value = reading_value;
    this.meter = meter;
  }

  public Reading(Date date, double reading_value, Meter meter) {
    this.date = date;
    this.reading_value = reading_value;
    this.meter = meter;
  }

  public Reading() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public Meter getMeter() {
    return meter;
  }

  public void setMeter(Meter meter) {
    this.meter = meter;
  }

  @Override
  public String toString() {
    return "Reading{" +
      "id=" + id +
      ", date=" + date +
      ", reading_value=" + reading_value +
      ", meter=" + meter.toString() +
      '}';
  }
}
