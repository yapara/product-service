package com.demo.productservice.mongo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Price {
  @Field("range")
  private String range;

  @Field("min")
  private float min;

  @Field("max")
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
