package com.demo.productservice.mongo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class DateType {
  @Field("date")
  private String date;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
