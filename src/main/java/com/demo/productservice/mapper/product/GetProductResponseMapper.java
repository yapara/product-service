package com.demo.productservice.mapper.product;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.response.product.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel Product to GetProductResponseMapper.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GetProductResponseMapper
    extends AbstractMapper<Product, GetProductResponse> {

  /**
   * Constructor for GetProductResponseMapper.
   */
  @Autowired
  public GetProductResponseMapper() {
    super(new GetProductResponse());
  }

  /**
   * Maps fields from Product to GetProductResponse.
   *
   * @param product Incoming Request
   * @return GetProductResponse
   */
  @Override
  public GetProductResponse map(final Product product) {
    super.map(product);

    final GetProductResponse getProductResponse = getDestination();
    getProductResponse.setProductId(product.getId());
    getProductResponse.setSellerId(product.getSellerId());
    //TODO: fill all fields
    return getProductResponse;
  }
}
