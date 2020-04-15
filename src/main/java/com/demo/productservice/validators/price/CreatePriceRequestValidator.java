package com.demo.productservice.validators.price;

import com.demo.productservice.request.price.CreatePriceRequest;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for CreatePriceRequest.
 */
@Component
public class CreatePriceRequestValidator extends BaseValidator implements IValidator<CreatePriceRequest> {

  public static final String CREATE_PRICE_REQUEST_IS_NULL = "Create price request is null.";
  public static final String PRODUCT_ID_IS_WRONG = "Product ID is wrongly specified.";

  /**
   * Validates the CreatePriceRequest.
   * @param CreatePriceRequest The createPriceRequest.
   */
  public void validate(final CreatePriceRequest createPriceRequest) {
    notNull(createPriceRequest, CREATE_PRICE_REQUEST_IS_NULL, CreatePriceRequest.class);
    validateString(createPriceRequest.getProductId(), PRODUCT_ID_IS_WRONG, CreatePriceRequest.class);
    //TODO: add other attribute validations also
  }
}
