package com.demo.productservice.validators;

import com.demo.productservice.exceptions.ApplicationErrorType;
import com.demo.productservice.exceptions.ValidationException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * BaseValidator has implementations for common validations.
 */

public abstract class BaseValidator {

  private static final String INVALID_REQUEST_VALUE = ApplicationErrorType.INVALID_REQUEST_VALUE.value();

  protected void notNull(Object target, String message, Class validatedType) {
    if (target == null) {
      throw new ValidationException(message, INVALID_REQUEST_VALUE, validatedType);
    }
  }

  protected void validateString(final String value, final String message, Class validatedType) {
    if (StringUtils.isEmpty(value)) {
      throw new ValidationException(message, INVALID_REQUEST_VALUE, validatedType);
    }
  }

  protected void validateNumber(final String value, final String message, Class validatedType) {
    if (!StringUtils.isNumeric(value)) {
      throw new ValidationException(message, INVALID_REQUEST_VALUE, validatedType);
    }
  }

  protected void validateNegativeNumber(final int number, final String message, Class validatedType) {
    if (number < 0) {
      throw new ValidationException(message, INVALID_REQUEST_VALUE, validatedType);
    }
  }

  protected void validateList(final List value, final String message, Class validatedType) {
    if (CollectionUtils.isEmpty(value)) {
      throw new ValidationException(message, INVALID_REQUEST_VALUE, validatedType);
    }
  }
}
