package com.demo.productservice.handlers.price;

import com.demo.productservice.handlers.AbstractHandler;
import com.demo.productservice.mapper.price.CreatePriceFailureResponseMapper;
import com.demo.productservice.mapper.price.CreatePriceReqToPriceMapper;
import com.demo.productservice.mapper.price.CreatePriceResponseMapper;
import com.demo.productservice.mongo.dao.PriceRepository;
import com.demo.productservice.mongo.model.ProductPrice;
import com.demo.productservice.request.price.CreatePriceRequest;
import com.demo.productservice.response.price.CreatePriceResponse;
import com.demo.productservice.validators.price.CreatePriceRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler/Orchestration for createPrice.
 */
@Component
public class CreatePriceHandler extends AbstractHandler<CreatePriceRequest, CreatePriceResponse> {
  private final CreatePriceRequestValidator createPriceRequestValidator;
  private final CreatePriceReqToPriceMapper createPriceReqToPriceMapper;
  private final CreatePriceFailureResponseMapper createPriceFailureResponseMapper;
  private final PriceRepository priceRepository;
  private final CreatePriceResponseMapper createPriceResponseMapper;

  /**
   * Initializes the CreatePriceHandler with required dependencies.
   *
   * @param CreatePriceRequestValidator  Validator for CreatePriceRequest
   * @param CreatePriceReqToPriceMapper Mapper for ProductPrice
   * @param CreatePriceResponseFailureMapper Mapper for failure response for CreatePriceResponse
   * @param ProductPriceRepository Repository for ProductPrice
   */
  @Autowired
  public CreatePriceHandler(final CreatePriceRequestValidator createPriceRequestValidator,
                            final CreatePriceReqToPriceMapper createPriceReqToPriceMapper,
                            final CreatePriceFailureResponseMapper createPriceFailureResponseMapper,
                            final PriceRepository priceRepository,
                            final CreatePriceResponseMapper createPriceResponseMapper) {
    this.createPriceRequestValidator = createPriceRequestValidator;
    this.createPriceReqToPriceMapper = createPriceReqToPriceMapper;
    this.createPriceFailureResponseMapper = createPriceFailureResponseMapper;
    this.priceRepository = priceRepository;
    this.createPriceResponseMapper = createPriceResponseMapper;
  }

  /**
   * Validates the incoming CreatePriceRequest from upstream callers.
   *
   * @param createPriceRequest CreatePriceRequest from upstream callers
   */
  @Override
  protected void validateRequest(final CreatePriceRequest createPriceRequest) {
    createPriceRequestValidator.validate(createPriceRequest);
  }

  /**
   * Builds the requests for the calls to DB, validates the final response and builds the returned
   * CreatePriceResponse body.
   *
   * @param createPriceRequest Incoming createPriceRequest from upstream callers
   * @return CreatePriceResponse Outgoing CreatePriceResponse
   */
  @Override
  protected CreatePriceResponse process(final CreatePriceRequest createPriceRequest) {
    final ProductPrice productPrice =
        createPriceReqToPriceMapper.map(createPriceRequest);
    priceRepository.save(productPrice);
    return createPriceResponseMapper.map(productPrice);
  }

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return CreatePriceResponse with failures mapped
   */
  @Override
  protected CreatePriceResponse handleException(
      final Exception exception, final CreatePriceRequest createPriceRequest) {
    return createPriceFailureResponseMapper.map(exception, createPriceRequest);
  }
}
