package com.demo.productservice.exceptions;

public class ValidationException extends BaseException {
  private static final long serialVersionUID = -509042357805697405L;
  private final String validatedType;

  public ValidationException(String message, String errorCode, Class validatedType) {
    super(message, errorCode, (Throwable)null);
    this.validatedType = validatedType.getSimpleName();
  }

  public String getValidatedType() {
    return this.validatedType;
  }
}
