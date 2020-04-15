package com.demo.productservice.validators.product;

import com.demo.productservice.request.product.GetProductRequest;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for GetProductRequestValidator.
 */
@Component
public class GetProductRequestValidator extends BaseValidator implements IValidator<GetProductRequest> {

  public static final String GET_PRODUCT_REQUEST_IS_NULL = "Get product request is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the getProductRequest.
   * @param GetProductRequest The getProductRequest.
   */
  public void validate(final GetProductRequest getProductRequest) {
    notNull(getProductRequest, GET_PRODUCT_REQUEST_IS_NULL, GetProductRequest.class);
    validateString(getProductRequest.getProductId(), PRODUCT_ID_IS_WRONG, String.class);
    //TODO: add other attribute validations also
  }
}
