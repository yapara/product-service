package com.demo.productservice.mongo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class MetaField {
  @Field("key")
  private String key;

  @Field("value")
  private String value;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
