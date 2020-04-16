package com.demo.productservice.validators.productprice;

import com.demo.productservice.request.productprice.GetProductPriceRequest;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for GetProductPriceRequestValidator.
 */
@Component
public class GetProductPriceRequestValidator extends BaseValidator implements IValidator<GetProductPriceRequest> {

  public static final String GET_PRODUCT_PRICE_REQUEST_IS_NULL = "Get product price request is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the getProductPriceRequest.
   * @param GetProductPriceRequest The getProductPriceRequest.
   */
  public void validate(final GetProductPriceRequest getProductPriceRequest) {
    notNull(getProductPriceRequest, GET_PRODUCT_PRICE_REQUEST_IS_NULL, GetProductPriceRequest.class);
    validateString(getProductPriceRequest.getProductId(), PRODUCT_ID_IS_WRONG, String.class);
    //TODO: add other attribute validations also
  }
}
