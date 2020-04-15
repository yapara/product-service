package com.demo.productservice.mapper.product;

import com.demo.productservice.mapper.FailureResponseMapper;
import com.demo.productservice.response.product.CreateProductResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from CreateProductResponse failure from an exception.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreateProductFailureResponseMapper extends FailureResponseMapper<CreateProductResponse> {
  /**
   * Initialize the CreateProductFailureResponseMapper.
   */
  public CreateProductFailureResponseMapper() {
    super(new CreateProductResponse());
  }
}
