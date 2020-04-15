package com.demo.productservice.handlers.productprice;

import com.demo.productservice.handlers.AbstractHandler;
import com.demo.productservice.mapper.product.CreateProductReqToProductMapper;
import com.demo.productservice.mapper.product.GetProductFailureResponseMapper;
import com.demo.productservice.mapper.product.GetProductResponseMapper;
import com.demo.productservice.mongo.dao.PriceRepository;
import com.demo.productservice.mongo.dao.ProductRepository;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.request.product.GetProductRequest;
import com.demo.productservice.request.productprice.GetProductPriceRequest;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.response.productprice.GetProductPriceResponse;
import com.demo.productservice.validators.product.GetProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler/Orchestration for getProductPrice.
 */
@Component
public class GetProductPriceHandler extends AbstractHandler<GetProductPriceRequest, GetProductPriceResponse> {
  private final GetProductPriceRequestValidator getProductPriceRequestValidator;
  private final GetProductPriceFailureResponseMapper getProductPriceFailureResponseMapper;
  private final ProductRepository productRepository;
  private final PriceRepository priceRepository;
  private final GetProductPriceResponseMapper getProductResponseMapper;

  /**
   * Initializes the GetProductHandler with required dependencies.
   *
   * @param GetProductRequestValidator  Validator for GetProductRequest
   * @param ProductMapper Mapper for Product
   * @param GetProductFailureResponseMapper Mapper for failure response for GetProductResponse
   * @param ProductRepository Repository for Product
   */
  @Autowired
  public GetProductPriceHandler(final GetProductRequestValidator getProductRequestValidator,
                                final CreateProductReqToProductMapper createProductReqToProductMapper,
                                final GetProductFailureResponseMapper getProductFailureResponseMapper,
                                final ProductRepository productRepository,
                                final GetProductResponseMapper getProductResponseMapper) {
    this.getProductRequestValidator = getProductRequestValidator;
    this.getProductFailureResponseMapper = getProductFailureResponseMapper;
    this.productRepository = productRepository;
    this.getProductResponseMapper = getProductResponseMapper;
  }

  /**
   * Validates the incoming productId from upstream callers.
   *
   * @param getProductRequest  from upstream callers
   */
  @Override
  protected void validateRequest(final GetProductRequest getProductRequest) {
    getProductRequestValidator.validate(getProductRequest);
  }

  /**
   * Builds the requests for the calls to DB, validates the final response and builds the returned
   * GetProductResponse body.
   *
   * @param  getProductRequest Incoming getProductRequest from upstream callers
   * @return GetProductResponse Outgoing GetProductResponse
   */
  @Override
  protected GetProductResponse process(final GetProductRequest getProductRequest) {
    Product product = productRepository.findById(getProductRequest.getProductId()).get();
    return getProductResponseMapper.map(product);
  }

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return GetProductResponse with failures mapped
   */
  @Override
  protected GetProductResponse handleException(
      final Exception exception, final GetProductRequest getProductRequest) {
    return getProductFailureResponseMapper.map(exception, getProductRequest);
  }
}
