package com.demo.productservice.exceptions;

public class ExternalException extends BaseException {

  /**
   * Creates ExternalException
   *
   * @param message - error message System.
   * @param errorCode - error code.
   */
  public ExternalException(
      String message, String errorCode) {
    super(message, errorCode, (Throwable)null);
  }

}
