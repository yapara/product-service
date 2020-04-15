package com.demo.productservice.validators;

import com.demo.productservice.exceptions.ValidationException;

public interface IValidator<T> {
  void validate(T var1) throws ValidationException;
}
