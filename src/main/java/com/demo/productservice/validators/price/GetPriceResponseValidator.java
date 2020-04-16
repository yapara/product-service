package com.demo.productservice.validators.price;

import com.demo.productservice.request.price.GetPriceRequest;
import com.demo.productservice.response.price.GetPriceResponse;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for GetPriceResponseValidator.
 */
@Component
public class GetPriceResponseValidator extends BaseValidator implements IValidator<GetPriceResponse> {

  public static final String GET_PRICE_RESPONSE_IS_NULL = "Get price response is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the getPriceResponse.
   * @param GetPriceResponse The getPriceResponse.
   */
  public void validate(final GetPriceResponse getPriceResponse) {
    notNull(getPriceResponse, GET_PRICE_RESPONSE_IS_NULL, GetPriceRequest.class);
    validateString(getPriceResponse.getProductId(), PRODUCT_ID_IS_WRONG, String.class);
    //TODO: add other attribute validations also
  }
}
