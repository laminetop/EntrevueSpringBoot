package com.example.entrevueSpringBoot.Exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {

  SITE_NOT_FOUND(1000),
  FORMATION_NOT_FOUND(1002),
  SITE_EXISTS_WITH_FORMATIONS(1001);

  private int code;

  ErrorCodes(int code) {
    this.code = code;
  }


}
