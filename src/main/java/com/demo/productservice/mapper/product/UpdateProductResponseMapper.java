package com.demo.productservice.mapper.product;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.response.product.UpdateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel Product to UpdateProductResponse.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UpdateProductResponseMapper
    extends AbstractMapper<Product, UpdateProductResponse> {

  /**
   * Constructor for UpdateProductResponseMapper.
   */
  @Autowired
  public UpdateProductResponseMapper() {
    super(new UpdateProductResponse());
  }

  /**
   * Maps fields from Product to UpdateProductResponse.
   *
   * @param product Incoming Request
   * @return UpdateProductResponse
   */
  @Override
  public UpdateProductResponse map(final Product product) {
    super.map(product);

    final UpdateProductResponse updateProductResponse = getDestination();
    updateProductResponse.setProductId(product.getId());
    //TODO: fill all fields
    return updateProductResponse;
  }
}
