package com.demo.productservice.request.product;

import java.io.Serializable;

public class WorkFlow implements Serializable {
  private static final long serialVersionUID = 7153766680603985979L;

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
