package com.example.entrevueSpringBoot.Exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {

  @Getter
  private ErrorCodes errorCode;


  public EntityNotFoundException(String message, ErrorCodes errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

}
