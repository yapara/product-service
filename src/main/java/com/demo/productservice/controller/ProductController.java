package com.demo.productservice.controller;
import com.codahale.metrics.Timer;
import com.demo.productservice.handlers.product.CreateProductHandler;
import com.demo.productservice.handlers.product.GetProductHandler;
import com.demo.productservice.handlers.product.UpdateProductHandler;
import com.demo.productservice.metrics.MetricsUtil;
import com.demo.productservice.request.Constants;
import com.demo.productservice.request.product.CreateProductRequest;
import com.demo.productservice.request.product.GetProductRequest;
import com.demo.productservice.request.product.UpdateProductRequest;
import com.demo.productservice.response.product.CreateProductResponse;
import com.demo.productservice.response.product.GetProductResponse;
import com.demo.productservice.response.product.UpdateProductResponse;
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
public class ProductController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
  private final Timer productTimer = MetricsUtil
      .registerTimer(getClass().getName(), "product");

  private final CreateProductHandler createProductHandler;
  private final GetProductHandler getProductHandler;
  private final UpdateProductHandler updateProductHandler;

  @Autowired
  public ProductController(final CreateProductHandler createProductHandler,
                           final GetProductHandler getProductHandler,
                           final UpdateProductHandler updateProductHandler) {
    this.createProductHandler = createProductHandler;
    this.getProductHandler = getProductHandler;
    this.updateProductHandler = updateProductHandler;

  }

  @ApiOperation(value = "Create the product details.")
  @RequestMapping(value = "/product",
      method = RequestMethod.POST,
      produces = Constants.MEDIA_TYPE_JSON,
      consumes = Constants.MEDIA_TYPE_JSON)
  @ResponseBody
  public ResponseEntity<CreateProductResponse> createProduct(
      @RequestBody final CreateProductRequest request) {
    final Timer.Context timer = productTimer.time();
    LOGGER.info(String.format(
        "ProductController.createProduct started for the sellerId %s", request.getSellerId()));
    //TODO: using point cut annotation, have to log the request.
    LOGGER.info("CreateProductRequest : "+ JsonUtility.objectToJson(request));
    try {
      CreateProductResponse createProductResponse = createProductHandler.handle(request);
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("CreateProductResponse : "+ JsonUtility.objectToJson(createProductResponse));
      return new ResponseEntity<>(createProductResponse, HttpStatus.OK);
    } finally {
      final long elapsedTime = timer.stop();
      LOGGER.info("Time taken to execute createProduct"+elapsedTime);
    }
  }

  @ApiOperation(value = "Get the product details.")
  @RequestMapping(value = "/product",
      method = RequestMethod.GET,
      produces = Constants.MEDIA_TYPE_JSON,
      consumes = Constants.MEDIA_TYPE_JSON)
  @ResponseBody
  public ResponseEntity<GetProductResponse> getProduct(@RequestParam(value = "productId") String productId) {
    final Timer.Context timer = productTimer.time();
    LOGGER.info(String.format(
        "ProductController.getProduct started for the productId %s", productId));
    //TODO: using point cut annotation, have to log the request.
    try {
      GetProductResponse getProductResponse = getProductHandler.handle(new GetProductRequest(productId));
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("GetProductResponse : "+ JsonUtility.objectToJson(getProductResponse));
      return new ResponseEntity<>(getProductResponse, HttpStatus.OK);
    } finally {
      final long elapsedTime = timer.stop();
      LOGGER.info("Time taken to execute getProduct"+elapsedTime);
    }
  }

  @ApiOperation(value = "Update the product details.")
  @RequestMapping(value = "/product",
      method = RequestMethod.PUT,
      produces = Constants.MEDIA_TYPE_JSON,
      consumes = Constants.MEDIA_TYPE_JSON)
  @ResponseBody
  public ResponseEntity<UpdateProductResponse> updateProduct(
      @RequestBody final UpdateProductRequest request) {
    final Timer.Context timer = productTimer.time();
    LOGGER.info(String.format(
        "ProductController.updateProduct started for the productId %s", request.getProductId()));
    //TODO: using point cut annotation, have to log the request.
    LOGGER.info("UpdateProductRequest : "+ JsonUtility.objectToJson(request));
    try {
      UpdateProductResponse updateProductResponse = updateProductHandler.handle(request);
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("UpdateProductResponse : "+ JsonUtility.objectToJson(updateProductResponse));
      return new ResponseEntity<>(updateProductResponse, HttpStatus.OK);
    } finally {
      final long elapsedTime = timer.stop();
      LOGGER.info("Time taken to execute updateProduct"+elapsedTime);
    }
  }
}
