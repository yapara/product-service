package com.demo.productservice.mapper.price;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.ProductPrice;
import com.demo.productservice.response.price.CreatePriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel ProductPrice to CreatePriceResponse.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreatePriceResponseMapper
    extends AbstractMapper<ProductPrice, CreatePriceResponse> {

  /**
   * Constructor for CreatePriceResponseMapper.
   */
  @Autowired
  public CreatePriceResponseMapper() {
    super(new CreatePriceResponse());
  }

  /**
   * Maps fields from ProductPrice to CreatePriceResponse.
   *
   * @param productPrice Incoming Request
   * @return CreatePriceResponse
   */
  @Override
  public CreatePriceResponse map(final ProductPrice productPrice) {
    super.map(productPrice);

    final CreatePriceResponse createPriceResponse = getDestination();
    createPriceResponse.setProductId(productPrice.getId());
    //TODO: fill all fields
    return createPriceResponse;
  }
}
