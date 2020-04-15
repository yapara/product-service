package com.demo.productservice.mongo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class WorkFlow {
  @Field("key")
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
