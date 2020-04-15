package com.demo.productservice.exceptions;

public enum ApplicationErrorType {
  INVALID_REQUEST_VALUE,
  INVALID_EXTERNAL_RESPONSE,
  MISSING_RESPONSE_DATA,
  INTERNAL_SERVER_ERROR,
  TIMEOUT,
  COMMUNICATION_FAILURE;

  private ApplicationErrorType() {
  }

  public String value() {
    return this.name();
  }

  public static ApplicationErrorType fromValue(String val) {
    return valueOf(val);
  }
}
