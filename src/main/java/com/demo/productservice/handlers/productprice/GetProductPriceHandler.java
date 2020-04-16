package com.demo.productservice.handlers.productprice;

import com.demo.productservice.builder.GetProductPriceResponseBuilder;
import com.demo.productservice.handlers.AbstractHandler;
import com.demo.productservice.mapper.productprice.GetProductPriceFailureResponseMapper;
import com.demo.productservice.proxy.IProductServiceProxy;
import com.demo.productservice.request.productprice.GetProductPriceRequest;
import com.demo.productservice.response.price.GetPriceResponse;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.response.productprice.GetProductPriceResponse;
import com.demo.productservice.validators.price.GetPriceResponseValidator;
import com.demo.productservice.validators.product.GetProductResponseValidator;
import com.demo.productservice.validators.productprice.GetProductPriceRequestValidator;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Handler/Orchestration for getProductPrice.
 */
@Component
public class GetProductPriceHandler extends AbstractHandler<GetProductPriceRequest, GetProductPriceResponse> {
  private final GetProductPriceRequestValidator getProductPriceRequestValidator;
  private final IProductServiceProxy productServiceProxy;
  private final GetProductResponseValidator getProductResponseValidator;
  private final GetPriceResponseValidator getPriceResponseValidator;
  private final ObjectFactory<GetProductPriceResponseBuilder> getProductPriceResponseBuilderFactory;
  private final GetProductPriceFailureResponseMapper getProductPriceFailureResponseMapper;


  /**
   * Initializes the GetProductHandler with required dependencies.
   *
   * @param GetProductPriceRequestValidator  Validator for GetProductPriceRequest
   * @param IProductServiceProxy proxy for IproductServiceProxy;;
   * @param ProductMapper Mapper for Product
   * @param GetProductResponseValidator Validator for GetProductResponse
   * @param GetPriceResponseValidator Validator for GetPriceResponse
   * @param GetProductPriceResponseBuilder Builder for GetProductPriceResponse
   * @param GetProductPriceFailureResponseMapper Mapper for failure response for GetProductPriceResponse
   */
  @Autowired
  public GetProductPriceHandler(final GetProductPriceRequestValidator getProductPriceRequestValidator,
                                final IProductServiceProxy productServiceProxy,
                                final GetProductResponseValidator getProductResponseValidator,
                                final GetPriceResponseValidator getPriceResponseValidator,
                                final ObjectFactory<GetProductPriceResponseBuilder> getProductPriceResponseBuilderFactory,
                                final GetProductPriceFailureResponseMapper getProductPriceFailureResponseMapper) {
    this.getProductPriceRequestValidator = getProductPriceRequestValidator;
    this.productServiceProxy = productServiceProxy;
    this.getProductResponseValidator = getProductResponseValidator;
    this.getPriceResponseValidator = getPriceResponseValidator;
    this.getProductPriceResponseBuilderFactory = getProductPriceResponseBuilderFactory;
    this.getProductPriceFailureResponseMapper = getProductPriceFailureResponseMapper;

  }

  /**
   * Validates the incoming productId from upstream callers.
   *
   * @param getProductPriceRequest  from upstream callers
   */
  @Override
  protected void validateRequest(final GetProductPriceRequest getProductPriceRequest) {
    getProductPriceRequestValidator.validate(getProductPriceRequest);
  }

  /**
   * Builds the requests for the calls to DB, validates the final response and builds the returned
   * GetProductPriceResponse body.
   *
   * @param  getProductPriceRequest Incoming getProductPriceRequest from upstream callers
   * @return GetProductPriceResponse Outgoing GetProductPriceResponse
   */
  @Override
  protected GetProductPriceResponse process(final GetProductPriceRequest getProductPriceRequest) {
    try {
      CompletableFuture<GetProductResponse> getProductResponse = productServiceProxy.getProduct(getProductPriceRequest.getProductId());
      getProductResponseValidator.validate(getProductResponse.get());
      CompletableFuture<GetPriceResponse> getPriceResponse = productServiceProxy.getPrice(getProductPriceRequest.getProductId());
      getPriceResponseValidator.validate(getPriceResponse.get());
      return getProductPriceResponseBuilderFactory.getObject()
          .setGetProductResponse(getProductResponse.get()).setGetPriceResponse(getPriceResponse.get()).build();
    } catch (Exception e) {
      return handleException(e, getProductPriceRequest);
    }
  }

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return GetProductPriceResponse with failures mapped
   */
  @Override
  protected GetProductPriceResponse handleException(
      final Exception exception, final GetProductPriceRequest getProductPriceRequest) {
    return getProductPriceFailureResponseMapper.map(exception, getProductPriceRequest);
  }
}
