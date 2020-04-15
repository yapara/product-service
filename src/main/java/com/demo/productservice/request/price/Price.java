package com.demo.productservice.request.price;

import java.io.Serializable;

public class Price implements Serializable {
  private static final long serialVersionUID = 7153766680604985979L;

  private String range;

  private float min;

  private float max;

  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  public float getMin() {
    return min;
  }

  public void setMin(float min) {
    this.min = min;
  }

  public float getMax() {
    return max;
  }

  public void setMax(float max) {
    this.max = max;
  }
}
