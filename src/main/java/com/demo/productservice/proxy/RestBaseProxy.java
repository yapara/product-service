package com.demo.productservice.proxy;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Base Proxy class which holds the RestTemplate.
 */
public class RestBaseProxy {
  protected final RestTemplate restTemplate = getRestTemplate();

  private RestTemplate getRestTemplate() {
    final RestTemplate restTemplate = new RestTemplate();

    final List<HttpMessageConverter<?>> convertersList = restTemplate.getMessageConverters();
    restTemplate.setMessageConverters(convertersList);

    return restTemplate;
  }

  protected void setRestTemplateTimeouts(int readTimeout, int connectionTimeout) {
    final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

    requestFactory.setReadTimeout(readTimeout);
    requestFactory.setConnectTimeout(connectionTimeout);

    restTemplate.setRequestFactory(requestFactory);
  }
}
