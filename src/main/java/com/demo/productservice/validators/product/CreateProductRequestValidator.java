package com.demo.productservice.validators.product;

import com.demo.productservice.request.product.CreateProductRequest;
import com.demo.productservice.validators.BaseValidator;
import com.demo.productservice.validators.IValidator;
import org.springframework.stereotype.Component;

/**
 * Validator for CreateProductRequest.
 */
@Component
public class CreateProductRequestValidator extends BaseValidator implements IValidator<CreateProductRequest> {

  public static final String CREATE_PRODUCT_REQUEST_IS_NULL = "Create product request is null.";
  public static final String SELLER_ID_IS_WRONG = "Seller ID is wrongly specified.";

  /**
   * Validates the CreateProductRequest.
   * @param CreateProductRequest The createProductRequest.
   */
  public void validate(final CreateProductRequest createProductRequest) {
    notNull(createProductRequest, CREATE_PRODUCT_REQUEST_IS_NULL, CreateProductRequest.class);
    validateNegativeNumber(createProductRequest.getSellerId(), SELLER_ID_IS_WRONG, CreateProductRequest.class);
    //TODO: add other attribute validations also
  }
}
