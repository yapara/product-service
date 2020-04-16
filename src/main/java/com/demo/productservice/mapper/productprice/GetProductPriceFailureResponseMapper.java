package com.demo.productservice.mapper.productprice;

import com.demo.productservice.mapper.FailureResponseMapper;
import com.demo.productservice.response.productprice.GetProductPriceResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from GetProductPriceFailureResponseMapper failure from an exception.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GetProductPriceFailureResponseMapper extends FailureResponseMapper<GetProductPriceResponse> {
  /**
   * Initialize the GetProductPriceFailureResponseMapper.
   */
  public GetProductPriceFailureResponseMapper() {
    super(new GetProductPriceResponse());
  }
}
