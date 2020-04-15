package com.demo.productservice.handlers.product;

import com.demo.productservice.handlers.AbstractHandler;
import com.demo.productservice.mapper.product.CreateProductFailureResponseMapper;
import com.demo.productservice.mapper.product.CreateProductResponseMapper;
import com.demo.productservice.mapper.product.CreateProductReqToProductMapper;
import com.demo.productservice.mongo.dao.ProductRepository;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.request.product.CreateProductRequest;
import com.demo.productservice.response.product.CreateProductResponse;
import com.demo.productservice.validators.product.CreateProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler/Orchestration for createProduct.
 */
@Component
public class CreateProductHandler extends AbstractHandler<CreateProductRequest, CreateProductResponse> {
  private final CreateProductRequestValidator createProductRequestValidator;
  private final CreateProductReqToProductMapper createProductReqToProductMapper;
  private final CreateProductFailureResponseMapper createProductFailureResponseMapper;
  private final ProductRepository productRepository;
  private final CreateProductResponseMapper createProductResponseMapper;

  /**
   * Initializes the CreateProductHandler with required dependencies.
   *
   * @param CreateProductRequestValidator  Validator for CreateProductRequest
   * @param ProductMapper Mapper for Product
   * @param CreateProductResponseFailureMapper Mapper for failure response for CreateProductResponse
   * @param ProductRepository Repository for Product
   */
  @Autowired
  public CreateProductHandler(final CreateProductRequestValidator createProductRequestValidator,
                              final CreateProductReqToProductMapper createProductReqToProductMapper,
                              final CreateProductFailureResponseMapper createProductFailureResponseMapper,
                              final ProductRepository productRepository,
                              final CreateProductResponseMapper createProductResponseMapper) {
    this.createProductRequestValidator = createProductRequestValidator;
    this.createProductReqToProductMapper = createProductReqToProductMapper;
    this.createProductFailureResponseMapper = createProductFailureResponseMapper;
    this.productRepository = productRepository;
    this.createProductResponseMapper = createProductResponseMapper;
  }

  /**
   * Validates the incoming CreateProductRequest from upstream callers.
   *
   * @param createProductRequest CreateProductRequest from upstream callers
   */
  @Override
  protected void validateRequest(final CreateProductRequest createProductRequest) {
    createProductRequestValidator.validate(createProductRequest);
  }

  /**
   * Builds the requests for the calls to DB, validates the final response and builds the returned
   * CreateProductResponse body.
   *
   * @param createProductRequest Incoming createProductRequest from upstream callers
   * @return CreateProductResponse Outgoing CreateProductResponse
   */
  @Override
  protected CreateProductResponse process(final CreateProductRequest createProductRequest) {
    final Product product =
        createProductReqToProductMapper.map(createProductRequest);
    productRepository.save(product);
    return createProductResponseMapper.map(product);
  }

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return CreateProductResponse with failures mapped
   */
  @Override
  protected CreateProductResponse handleException(
      final Exception exception, final CreateProductRequest createProductRequest) {
    return createProductFailureResponseMapper.map(exception, createProductRequest);
  }
}
