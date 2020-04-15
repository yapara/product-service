package com.demo.productservice.mapper.product;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.dao.ProductRepository;
import com.demo.productservice.mongo.model.Product;
import com.demo.productservice.request.product.UpdateProductRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel UpdateProductRequest to Product.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UpdateProductReqToProductMapper
    extends AbstractMapper<UpdateProductRequest, Product> {
  private final ProductRepository productRepository;

  /**
   * Constructor for ProductMapper.
   */
  @Autowired
  public UpdateProductReqToProductMapper(final ProductRepository productRepository) {
    super(new Product());
    this.productRepository = productRepository;
  }

  /**
   * Maps fields from UpdateProductRequest to Product.
   *
   * @param UpdateProductRequest Incoming Request
   * @return Product
   */
  @Override
  public Product map(final UpdateProductRequest updateProductRequest) {
    super.map(updateProductRequest);
    final Product existingProduct = productRepository.findById(updateProductRequest.getProductId()).get();
    final Product product = getDestination();
    product.setManufacturer(existingProduct.getManufacturer());
    if(!StringUtils.isEmpty(updateProductRequest.getManufacturer())) {
      product.setManufacturer(updateProductRequest.getManufacturer());
    }
    //TODO: fill all fields
    return product;
  }
}
