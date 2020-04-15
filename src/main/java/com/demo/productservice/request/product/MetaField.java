package com.demo.productservice.request.product;

import java.io.Serializable;

public class MetaField implements Serializable {
  private static final long serialVersionUID = 7153766680603985975L;

  private String key;

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
