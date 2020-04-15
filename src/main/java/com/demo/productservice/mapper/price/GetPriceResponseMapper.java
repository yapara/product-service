package com.demo.productservice.mapper.price;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.ProductPrice;
import com.demo.productservice.response.price.GetPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel ProductPrice to GetPriceResponseMapper.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GetPriceResponseMapper
    extends AbstractMapper<ProductPrice, GetPriceResponse> {

  /**
   * Constructor for GetPriceResponseMapper.
   */
  @Autowired
  public GetPriceResponseMapper() {
    super(new GetPriceResponse());
  }

  /**
   * Maps fields from Product to GetPriceResponse.
   *
   * @param productPrice Incoming Request
   * @return GetPriceResponse
   */
  @Override
  public GetPriceResponse map(final ProductPrice productPrice) {
    super.map(productPrice);

    final GetPriceResponse getPriceResponse = getDestination();
    getPriceResponse.setProductId(productPrice.getProductId());
    //TODO: fill all fields
    return getPriceResponse;
  }
}
