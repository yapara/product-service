package com.demo.productservice.validators.product;

import com.demo.productservice.request.product.UpdateProductRequest;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for UpdateProductRequest.
 */
@Component
public class UpdateProductRequestValidator extends BaseValidator implements IValidator<UpdateProductRequest> {

  public static final String UPDATE_PRODUCT_REQUEST_IS_NULL = "Update product request is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the UpdateProductRequest.
   * @param UpdateProductRequest The updateProductRequest.
   */
  public void validate(final UpdateProductRequest updateProductRequest) {
    notNull(updateProductRequest, UPDATE_PRODUCT_REQUEST_IS_NULL, UpdateProductRequest.class);
    validateString(updateProductRequest.getProductId(), PRODUCT_ID_IS_WRONG, UpdateProductRequest.class);
    //TODO: add other attribute validations also
  }
}
