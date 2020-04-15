package com.demo.productservice.response.price;

import com.demo.productservice.response.BaseResponse;

import java.io.Serializable;

public class CreatePriceResponse extends BaseResponse implements Serializable {
  private static final long serialVersionUID = 4096979073888123551L;

  private String productId;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
