package com.demo.productservice.mapper.product;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.response.product.CreateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel Product to CreateProductResponse.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreateProductResponseMapper
    extends AbstractMapper<Product, CreateProductResponse> {

  /**
   * Constructor for CreateProductResponseMapper.
   */
  @Autowired
  public CreateProductResponseMapper() {
    super(new CreateProductResponse());
  }

  /**
   * Maps fields from Product to CreateProductResponse.
   *
   * @param product Incoming Request
   * @return CreateProductResponse
   */
  @Override
  public CreateProductResponse map(final Product product) {
    super.map(product);

    final CreateProductResponse createProductResponse = getDestination();
    createProductResponse.setProductId(product.getId());
    //TODO: fill all fields
    return createProductResponse;
  }
}
