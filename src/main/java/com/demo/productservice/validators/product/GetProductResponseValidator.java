package com.demo.productservice.validators.product;

import com.demo.productservice.request.product.GetProductRequest;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for GetProductResponseValidator.
 */
@Component
public class GetProductResponseValidator extends BaseValidator implements IValidator<GetProductResponse> {

  public static final String GET_PRODUCT_RESPONSE_IS_NULL = "Get product response is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the getProductResponse.
   * @param GetProductResponse The getProductResponse.
   */
  public void validate(final GetProductResponse getProductResponse) {
    notNull(getProductResponse, GET_PRODUCT_RESPONSE_IS_NULL, GetProductRequest.class);
    validateString(getProductResponse.getProductId(), PRODUCT_ID_IS_WRONG, String.class);
    //TODO: add other attribute validations also
  }
}
