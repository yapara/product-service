package com.demo.productservice.exceptions;

public class BaseException extends RuntimeException {
  private static final long serialVersionUID = -5972739490007343816L;
  private final String errorCode;

  public BaseException(String message, String errorCode) {
    this(message, errorCode, (Throwable)null);
  }

  public BaseException(String message, String errorCode, Throwable nestedException) {
    super(message, nestedException);
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return this.errorCode;
  }

}
