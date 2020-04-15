package com.demo.productservice.request;

public class BaseRequest {
  private String clientHost;

  private String clientApplication;

  private String languageId;

  private String userId;

  public String getClientHost() {
    return clientHost;
  }

  public void setClientHost(String clientHost) {
    this.clientHost = clientHost;
  }

  public String getClientApplication() {
    return clientApplication;
  }

  public void setClientApplication(String clientApplication) {
    this.clientApplication = clientApplication;
  }

  public String getLanguageId() {
    return languageId;
  }

  public void setLanguageId(String languageId) {
    this.languageId = languageId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
