package com.demo.productservice.request.product;

import com.demo.productservice.request.BaseRequest;

import java.io.Serializable;

public class GetProductRequest extends BaseRequest implements Serializable {
  //TODO: baseRequest details will be filled also
  private String productId;

  public GetProductRequest(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
