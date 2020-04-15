package com.demo.productservice.mapper.product;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.request.product.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel CreateProductRequest to Product.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreateProductReqToProductMapper
    extends AbstractMapper<CreateProductRequest, Product> {

  /**
   * Constructor for ProductMapper.
   */
  @Autowired
  public CreateProductReqToProductMapper() {
    super(new Product());
  }

  /**
   * Maps fields from CreateProductRequest to Product.
   *
   * @param CreateProductRequest Incoming Request
   * @return Product
   */
  @Override
  public Product map(final CreateProductRequest createProductRequest) {
    super.map(createProductRequest);

    final Product product = getDestination();
    product.setSellerId(createProductRequest.getSellerId());
    //TODO: fill all fields
    return product;
  }
}
