package com.demo.productservice.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceabilityProperties implements IServiceabilityProperties {
  @Value("${productservice.url.endpoint}")
  private String productServiceUrlEndpoint;

  @Value("${productservice.url.producturi}")
  private String productUri;

  @Value("${productservice.url.priceuri}")
  private String priceUri;

  @Value("${productservice.media.type}")
  private String mediaType;

  @Value("${productservice.media.subtype}")
  private String mediaSubType;

  @Value("${productservice.timeout.readTimeout:10000}")
  private String readTimeout;

  @Value("${productservice.timeout.connectionTimeout:10000}")
  private String connectionTimeout;

  @Override
  public String getMediaType() {
    return mediaType;
  }

  @Override
  public String getMediaSubType() {
    return mediaSubType;
  }

  @Override
  public int getReadTimeout() {
    return Integer.valueOf(readTimeout);
  }

  @Override
  public int getConnectionTimeout() {
    return Integer.valueOf(connectionTimeout);
  }

  @Override
  public String getProductServiceUrlEndpoint() {
    return productServiceUrlEndpoint;
  }

  public String getProductUri() {
    return productUri;
  }

  public String getPriceUri() {
    return priceUri;
  }
}
