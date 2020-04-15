package com.demo.productservice.validators.price;

import com.demo.productservice.request.price.GetPriceRequest;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for GetProductPriceRequestValidator.
 */
@Component
public class GetPriceRequestValidator extends BaseValidator implements IValidator<GetPriceRequest> {

  public static final String GET_PRICE_REQUEST_IS_NULL = "Get price request is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the getPriceRequest.
   * @param GetPriceRequest The getPriceRequest.
   */
  public void validate(final GetPriceRequest getPriceRequest) {
    notNull(getPriceRequest, GET_PRICE_REQUEST_IS_NULL, GetPriceRequest.class);
    validateString(getPriceRequest.getProductId(), PRODUCT_ID_IS_WRONG, String.class);
    //TODO: add other attribute validations also
  }
}
