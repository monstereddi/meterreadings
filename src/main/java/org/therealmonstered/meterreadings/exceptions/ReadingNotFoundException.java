package org.therealmonstered.meterreadings.exceptions;

public class ReadingNotFoundException extends RuntimeException{

  public ReadingNotFoundException(String message) {
    super(message);
  }
}
