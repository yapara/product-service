package com.demo.productservice.proxy;

public interface IServiceabilityProperties {

  int getReadTimeout();

  int getConnectionTimeout();

  String getProductServiceUrlEndpoint();

  String getProductUri();

  String getPriceUri();

  String getMediaType();

  String getMediaSubType();

}
