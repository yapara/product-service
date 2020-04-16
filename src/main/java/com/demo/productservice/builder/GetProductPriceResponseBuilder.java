package com.demo.productservice.builder;

import com.demo.productservice.response.Price;
import com.demo.productservice.response.price.GetPriceResponse;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.response.productprice.GetProductPriceResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * GetProductPriceResponseBuilder.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GetProductPriceResponseBuilder
    extends AbstractBuilder<GetProductPriceResponse> {

  private GetProductResponse getProductResponse;

  private GetPriceResponse getPriceResponse;

  public GetProductPriceResponseBuilder setGetProductResponse(GetProductResponse getProductResponse) {
    this.getProductResponse = getProductResponse;
    return this;
  }

  public GetProductPriceResponseBuilder setGetPriceResponse(GetPriceResponse getPriceResponse) {
    this.getPriceResponse = getPriceResponse;
    return this;
  }

  /**
   * Builds GetProductPriceResponse.
   * @return GetProductPriceResponse.
   */
  @Override
  protected GetProductPriceResponse buildInternal() {
    final GetProductPriceResponse request = new GetProductPriceResponse();
    request.setProductId(getProductResponse.getProductId());
    //TODO: better use one more builder for Price also
    final Price price = new Price();
    price.setRange(getPriceResponse.getPrice().getRange());
    request.setPrice(price);
    return request;
  }
}
