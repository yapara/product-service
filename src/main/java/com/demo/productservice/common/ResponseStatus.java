package com.demo.productservice.common;

public enum ResponseStatus {
  SUCCESS("Success"),
  WARNING("Warning"),
  PENDING("Pending"),
  FAILURE("Failure"),
  DUPLICATE_MESSAGE("DuplicateMessage"),
  FAILURES("Failures");

  private final String value;

  ResponseStatus(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ResponseStatus fromValue(String v) {
    for (ResponseStatus c: ResponseStatus.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
