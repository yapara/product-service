package com.demo.productservice.response;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaseResponse {
  private String errorType;

  private String errorCode;

  private String error;

  private List<String> errorDescription;

  private List<String> errorMessages;

  private String status;

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public List<String> getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(List<String> errorDescription) {
    this.errorDescription = errorDescription;
  }

  public List<String> getErrorMessages() {
    if ( errorMessages == null) {
      errorMessages = new ArrayList<>() ;
    }

    return errorMessages;
  }

  public void setErrorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
