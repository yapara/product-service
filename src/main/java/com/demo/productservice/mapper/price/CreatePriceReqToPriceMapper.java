package com.demo.productservice.mapper.price;

import com.demo.productservice.mapper.AbstractMapper;
import com.demo.productservice.mongo.model.ProductPrice;
import com.demo.productservice.request.price.CreatePriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Mapper from cancel CreatePriceRequest to Product.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreatePriceReqToPriceMapper
    extends AbstractMapper<CreatePriceRequest, ProductPrice> {

  /**
   * Constructor for CreatePriceReqToPriceMapper.
   */
  @Autowired
  public CreatePriceReqToPriceMapper() {
    super(new ProductPrice());
  }

  /**
   * Maps fields from CreatePriceRequest to ProductPrice.
   *
   * @param CreatePriceRequest Incoming Request
   * @return ProductPrice
   */
  @Override
  public ProductPrice map(final CreatePriceRequest createPriceRequest) {
    super.map(createPriceRequest);

    final ProductPrice productPrice = getDestination();
    productPrice.setProductId(createPriceRequest.getProductId());
    //TODO: fill all fields
    return productPrice;
  }
}
