package com.demo.productservice.response.price;

import com.demo.productservice.request.price.Price;
import com.demo.productservice.response.BaseResponse;

import java.io.Serializable;

public class GetPriceResponse extends BaseResponse implements Serializable {
  private static final long serialVersionUID = 4096970073888123550L;

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
