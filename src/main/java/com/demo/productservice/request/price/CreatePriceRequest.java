package com.demo.productservice.request.price;

import com.demo.productservice.request.BaseRequest;
import com.demo.productservice.request.Constants;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CreatePriceRequest extends BaseRequest implements Serializable {
  private static final long serialVersionUID = 6997185285305564166L;

  @ApiModelProperty(value = Constants.DOC_PRODUCT_ID, required = true)
  private String productId;

  private Price price;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }
}
