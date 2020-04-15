package com.demo.productservice.handlers.product;

import com.demo.productservice.handlers.AbstractHandler;
import com.demo.productservice.mapper.product.UpdateProductFailureResponseMapper;
import com.demo.productservice.mapper.product.UpdateProductReqToProductMapper;
import com.demo.productservice.mapper.product.UpdateProductResponseMapper;
import com.demo.productservice.mongo.dao.ProductRepository;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.request.product.UpdateProductRequest;
import com.demo.productservice.response.product.UpdateProductResponse;
import com.demo.productservice.validators.product.UpdateProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler/Orchestration for createProduct.
 */
@Component
public class UpdateProductHandler extends AbstractHandler<UpdateProductRequest, UpdateProductResponse> {
  private final UpdateProductRequestValidator updateProductRequestValidator;
  private final UpdateProductReqToProductMapper updateProductReqToProductMapper;
  private final UpdateProductFailureResponseMapper updateProductFailureResponseMapper;
  private final ProductRepository productRepository;
  private final UpdateProductResponseMapper updateProductResponseMapper;

  /**
   * Initializes the UpdateProductHandler with required dependencies.
   *
   * @param UpdateProductRequestValidator  Validator for UpdateProductRequest
   * @param ProductMapper Mapper for Product
   * @param UpdateProductResponseFailureMapper Mapper for failure response for UpdateProductResponse
   * @param ProductRepository Repository for Product
   */
  @Autowired
  public UpdateProductHandler(final UpdateProductRequestValidator updateProductRequestValidator,
                              final UpdateProductReqToProductMapper updateProductReqToProductMapper,
                              final UpdateProductFailureResponseMapper updateProductFailureResponseMapper,
                              final ProductRepository productRepository,
                              final UpdateProductResponseMapper updateProductResponseMapper) {
    this.updateProductRequestValidator = updateProductRequestValidator;
    this.updateProductReqToProductMapper = updateProductReqToProductMapper;
    this.updateProductFailureResponseMapper = updateProductFailureResponseMapper;
    this.productRepository = productRepository;
    this.updateProductResponseMapper = updateProductResponseMapper;
  }

  /**
   * Validates the incoming UpdateProductRequest from upstream callers.
   *
   * @param updateProductRequest UpdateProductRequest from upstream callers
   */
  @Override
  protected void validateRequest(final UpdateProductRequest updateProductRequest) {
    updateProductRequestValidator.validate(updateProductRequest);
  }

  /**
   * Builds the requests for the calls to DB, validates the final response and builds the returned
   * UpdateProductResponse body.
   *
   * @param updateProductRequest Incoming updateProductRequest from upstream callers
   * @return UpdateProductResponse Outgoing UpdateProductResponse
   */
  @Override
  protected UpdateProductResponse process(final UpdateProductRequest updateProductRequest) {
    final Product product =
        updateProductReqToProductMapper.map(updateProductRequest);
    productRepository.save(product);
    return updateProductResponseMapper.map(product);
  }

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return UpdateProductResponse with failures mapped
   */
  @Override
  protected UpdateProductResponse handleException(
      final Exception exception, final UpdateProductRequest updateProductRequest) {
    return updateProductFailureResponseMapper.map(exception, updateProductRequest);
  }
}
