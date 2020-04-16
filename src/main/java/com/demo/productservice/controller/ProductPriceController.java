package com.demo.productservice.controller;
import com.codahale.metrics.Timer;
import com.demo.productservice.handlers.product.CreateProductHandler;
import com.demo.productservice.handlers.product.GetProductHandler;
import com.demo.productservice.handlers.product.UpdateProductHandler;
import com.demo.productservice.handlers.productprice.GetProductPriceHandler;
import com.demo.productservice.metrics.MetricsUtil;
import com.demo.productservice.request.Constants;
import com.demo.productservice.request.product.CreateProductRequest;
import com.demo.productservice.request.product.GetProductRequest;
import com.demo.productservice.request.product.UpdateProductRequest;
import com.demo.productservice.request.productprice.GetProductPriceRequest;
import com.demo.productservice.response.product.CreateProductResponse;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.response.product.UpdateProductResponse;
import com.demo.productservice.response.productprice.GetProductPriceResponse;
import com.demo.productservice.utility.JsonUtility;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 */
//TODO: using point cut  annotation, have to log the request and response.
@RestController
@RequestMapping("/api/v1")
public class ProductPriceController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductPriceController.class);
  private final Timer productTimer = MetricsUtil
      .registerTimer(getClass().getName(), "productprice");

  private final GetProductPriceHandler getProductPriceHandler;

  @Autowired
  public ProductPriceController(final GetProductPriceHandler getProductPriceHandler) {
    this.getProductPriceHandler = getProductPriceHandler;
  }

  @ApiOperation(value = "Get the product price details.")
  @RequestMapping(value = "/productprice",
      method = RequestMethod.GET,
      produces = Constants.MEDIA_TYPE_JSON,
      consumes = Constants.MEDIA_TYPE_JSON)
  @ResponseBody
  public ResponseEntity<GetProductPriceResponse> getProductPrice(@RequestParam(value = "productId") String productId) {
    final Timer.Context timer = productTimer.time();
    LOGGER.info(String.format(
        "ProductController.getProductPrice started for the productId %s", productId));
    //TODO: using point cut annotation, have to log the request.
    try {
      GetProductPriceResponse getProductPriceResponse = getProductPriceHandler.handle(new GetProductPriceRequest(productId));
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("GetProductPriceResponse : "+ JsonUtility.objectToJson(getProductPriceResponse));
      return new ResponseEntity<>(getProductPriceResponse, HttpStatus.OK);
    } finally {
      final long elapsedTime = timer.stop();
      LOGGER.info("Time taken to execute getProductPrice"+elapsedTime);
    }
  }
}
