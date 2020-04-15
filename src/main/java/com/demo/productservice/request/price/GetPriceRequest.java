package com.demo.productservice.request.price;

import com.demo.productservice.request.BaseRequest;

import java.io.Serializable;

public class GetPriceRequest extends BaseRequest implements Serializable {
  //TODO: baseRequest details will be filled also
  private String productId;

  public GetPriceRequest(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
