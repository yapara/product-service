package com.demo.productservice.handlers.price;

import com.demo.productservice.handlers.AbstractHandler;
import com.demo.productservice.mapper.price.CreatePriceReqToPriceMapper;
import com.demo.productservice.mapper.price.GetPriceFailureResponseMapper;
import com.demo.productservice.mapper.price.GetPriceResponseMapper;
import com.demo.productservice.mongo.dao.PriceRepository;
import com.demo.productservice.mongo.model.ProductPrice;
import com.demo.productservice.request.price.GetPriceRequest;
import com.demo.productservice.response.price.GetPriceResponse;
import com.demo.productservice.validators.price.GetPriceRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler/Orchestration for getPrice.
 */
@Component
public class GetPriceHandler extends AbstractHandler<GetPriceRequest, GetPriceResponse> {
  private final GetPriceRequestValidator getPriceRequestValidator;
  private final GetPriceFailureResponseMapper getPriceFailureResponseMapper;
  private final PriceRepository priceRepository;
  private final GetPriceResponseMapper getPriceResponseMapper;

  /**
   * Initializes the GetPriceHandler with required dependencies.
   *
   * @param GetPriceRequestValidator  Validator for GetPriceRequest
   * @param CreatePriceReqToPriceMapper Mapper for ProductPrice
   * @param GetPriceFailureResponseMapper Mapper for failure response for GetPriceResponse
   * @param ProductPriceRepository Repository for ProductPrice
   */
  @Autowired
  public GetPriceHandler(final GetPriceRequestValidator getPriceRequestValidator,
                         final CreatePriceReqToPriceMapper createPriceReqToPriceMapper,
                         final GetPriceFailureResponseMapper getPriceFailureResponseMapper,
                         final PriceRepository priceRepository,
                         final GetPriceResponseMapper getPriceResponseMapper) {
    this.getPriceRequestValidator = getPriceRequestValidator;
    this.getPriceFailureResponseMapper = getPriceFailureResponseMapper;
    this.priceRepository = priceRepository;
    this.getPriceResponseMapper = getPriceResponseMapper;
  }

  /**
   * Validates the incoming productId from upstream callers.
   *
   * @param getPriceRequest  from upstream callers
   */
  @Override
  protected void validateRequest(final GetPriceRequest getPriceRequest) {
    getPriceRequestValidator.validate(getPriceRequest);
  }

  /**
   * Builds the requests for the calls to DB, validates the final response and builds the returned
   * GetPriceResponse body.
   *
   * @param  getPriceRequest Incoming getPriceRequest from upstream callers
   * @return GetPriceResponse Outgoing GetPriceResponse
   */
  @Override
  protected GetPriceResponse process(final GetPriceRequest getPriceRequest) {
    ProductPrice productPrice = priceRepository.findById(getPriceRequest.getProductId()).get();
    return getPriceResponseMapper.map(productPrice);
  }

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return GetPriceResponse with failures mapped
   */
  @Override
  protected GetPriceResponse handleException(
      final Exception exception, final GetPriceRequest getPriceRequest) {
    return getPriceFailureResponseMapper.map(exception, getPriceRequest);
  }
}
