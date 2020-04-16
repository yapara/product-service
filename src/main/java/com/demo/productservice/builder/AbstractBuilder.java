package com.demo.productservice.builder;

import com.demo.productservice.exceptions.ApplicationErrorType;
import com.demo.productservice.exceptions.BaseException;

public abstract class AbstractBuilder<T> {
  private static final String IS_BUILT_EXCEPTION = "Target object has already been built. Instantiate a new builder.";
  private boolean isBuilt;

  public AbstractBuilder() {
  }

  public T build() {
    if (this.isBuilt) {
      throw new BaseException("Target object has already been built. Instantiate a new builder.", ApplicationErrorType.INTERNAL_SERVER_ERROR.value());
    } else {
      this.isBuilt = true;
      return this.buildInternal();
    }
  }

  protected abstract T buildInternal();
}