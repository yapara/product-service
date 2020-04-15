package com.demo.productservice.response.product;

import com.demo.productservice.response.BaseResponse;

import java.io.Serializable;

public class UpdateProductResponse extends BaseResponse implements Serializable {
  private static final long serialVersionUID = 4096979073888123561L;

  private String productId;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
