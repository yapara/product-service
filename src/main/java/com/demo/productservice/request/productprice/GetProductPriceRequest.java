package com.demo.productservice.request.productprice;

import com.demo.productservice.request.BaseRequest;

import java.io.Serializable;

public class GetProductPriceRequest extends BaseRequest implements Serializable {
  //TODO: baseRequest details will be filled also
  private String productId;

  public GetProductPriceRequest(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
