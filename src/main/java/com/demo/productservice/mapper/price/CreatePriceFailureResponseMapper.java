package com.demo.productservice.mapper.price;

import com.demo.productservice.mapper.FailureResponseMapper;
import com.demo.productservice.response.price.CreatePriceResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from CreatePriceResponse failure from an exception.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreatePriceFailureResponseMapper extends FailureResponseMapper<CreatePriceResponse> {
  /**
   * Initialize the CreatePriceFailureResponseMapper.
   */
  public CreatePriceFailureResponseMapper() {
    super(new CreatePriceResponse());
  }
}
