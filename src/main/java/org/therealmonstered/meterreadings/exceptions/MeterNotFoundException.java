package org.therealmonstered.meterreadings.exceptions;

public class MeterNotFoundException extends RuntimeException{

  public MeterNotFoundException(String message) {
    super(message);
  }
}
