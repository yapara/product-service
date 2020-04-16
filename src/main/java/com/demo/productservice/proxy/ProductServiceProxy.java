package com.demo.productservice.proxy;

import com.codahale.metrics.Timer;
import com.demo.productservice.exceptions.ApplicationErrorType;
import com.demo.productservice.exceptions.ExternalException;
import com.demo.productservice.metrics.MetricsUtil;
import com.demo.productservice.response.price.GetPriceResponse;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.utility.JsonUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.concurrent.CompletableFuture;

@Component
public class ProductServiceProxy extends RestBaseProxy implements IProductServiceProxy {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceProxy.class);

  private final IServiceabilityProperties serviceabilityProperties;

  private final Timer timerGetProductResponse = MetricsUtil.registerTimer(
      ProductServiceProxy.class.getName(), "getProductResponse");

  private final Timer timerGetPriceResponse = MetricsUtil.registerTimer(
      ProductServiceProxy.class.getName(), "getPriceResponse");

  @Autowired
  public ProductServiceProxy(IServiceabilityProperties serviceabilityProperties) {
    this.serviceabilityProperties = serviceabilityProperties;
  }

  @Async
  @Override
  public CompletableFuture<GetProductResponse> getProduct(String productId) {

    setRestTemplateTimeouts(serviceabilityProperties.getReadTimeout(),
            serviceabilityProperties.getConnectionTimeout());
    try {
      // Set the Content-Type header
      final HttpHeaders requestHeaders = new HttpHeaders();
      requestHeaders.setContentType(new MediaType(this.serviceabilityProperties.getMediaType(),
              this.serviceabilityProperties.getMediaSubType()));
      //Set the request
      final HttpEntity<String> requestEntity =
              new HttpEntity<>(requestHeaders);
      // Make the HTTP POST request, get the response
      final ResponseEntity<GetProductResponse> responseEntity;
      final Timer.Context tc = timerGetProductResponse.time();

      try {
        //TODO: using point cut annotation, have to log the request.
        LOGGER.info(String.format(
            "Calling to Productservice.getProduct started for the productId %s", productId));

        responseEntity = restTemplate.exchange(
                this.serviceabilityProperties.getProductServiceUrlEndpoint()+this.serviceabilityProperties.getProductUri()+"?productId="+productId,
                HttpMethod.GET, requestEntity,
            GetProductResponse.class);
      } finally {
        tc.stop();
      }

      if (responseEntity == null || responseEntity.getBody() == null) {
        throw new ExternalException(ApplicationErrorType.UNKNOWN_ERROR.value(),
                "Product REST service returned a null response");
      }

      if (responseEntity.getBody().getError() != null) {
        throw new ExternalException(responseEntity.getBody().getErrorCode(),
            responseEntity.getBody().getErrorMessages().get(0));
      }

      GetProductResponse getProductResponse = responseEntity.getBody();
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("GetProductResponse from the product Service : "+ JsonUtility.objectToJson(getProductResponse));

      return CompletableFuture.completedFuture(getProductResponse);
    } catch (RestClientException ex) {
      LOGGER.error("RestClientException"+ex.getMessage());
      throw new ExternalException(ApplicationErrorType.CONNECTION_ERROR.value(),
              ex.getMessage());
    }
  }

  @Async
  @Override
  public CompletableFuture<GetPriceResponse> getPrice(String productId) {

    setRestTemplateTimeouts(serviceabilityProperties.getReadTimeout(),
        serviceabilityProperties.getConnectionTimeout());
    try {
      // Set the Content-Type header
      final HttpHeaders requestHeaders = new HttpHeaders();
      requestHeaders.setContentType(new MediaType(this.serviceabilityProperties.getMediaType(),
          this.serviceabilityProperties.getMediaSubType()));
      //Set the request
      final HttpEntity<String> requestEntity =
          new HttpEntity<>(requestHeaders);
      // Make the HTTP POST request, get the response
      final ResponseEntity<GetPriceResponse> responseEntity;
      final Timer.Context tc = timerGetProductResponse.time();

      try {
        //TODO: using point cut annotation, have to log the request.
        LOGGER.info(String.format(
            "Calling to Productservice.getPrice started for the productId %s", productId));

        responseEntity = restTemplate.exchange(
            this.serviceabilityProperties.getProductServiceUrlEndpoint()+this.serviceabilityProperties.getPriceUri()+"?productId="+productId,
            HttpMethod.GET, requestEntity,
            GetPriceResponse.class);
      } finally {
        tc.stop();
      }

      if (responseEntity == null || responseEntity.getBody() == null) {
        throw new ExternalException(ApplicationErrorType.UNKNOWN_ERROR.value(),
            "Price REST service returned a null response");
      }

      if (responseEntity.getBody().getError() != null) {
        throw new ExternalException(responseEntity.getBody().getErrorCode(),
            responseEntity.getBody().getErrorMessages().get(0));
      }

      GetPriceResponse getProductResponse = responseEntity.getBody();
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("GetPriceResponse from the product Service : "+ JsonUtility.objectToJson(getProductResponse));

      return CompletableFuture.completedFuture(getProductResponse);
    } catch (RestClientException ex) {
      LOGGER.error("RestClientException"+ex.getMessage());
      throw new ExternalException(ApplicationErrorType.CONNECTION_ERROR.value(),
          ex.getMessage());
    }
  }
}
