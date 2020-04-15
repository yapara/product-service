package com.demo.productservice.mapper.price;

import com.demo.productservice.mapper.FailureResponseMapper;
import com.demo.productservice.response.price.GetPriceResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from GetPriceResponse failure from an exception.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GetPriceFailureResponseMapper extends FailureResponseMapper<GetPriceResponse> {
  /**
   * Initialize the GetProductPriceFailureResponseMapper.
   */
  public GetPriceFailureResponseMapper() {
    super(new GetPriceResponse());
  }
}
