package com.demo.productservice.request.product;

import java.io.Serializable;

public class DateType implements Serializable {
  private static final long serialVersionUID = 7153766680603985976L;

  private String date;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
