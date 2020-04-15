package com.demo.productservice.controller;
import com.codahale.metrics.Timer;
import com.demo.productservice.handlers.price.CreatePriceHandler;
import com.demo.productservice.handlers.price.GetPriceHandler;
import com.demo.productservice.metrics.MetricsUtil;
import com.demo.productservice.request.Constants;
import com.demo.productservice.request.price.CreatePriceRequest;
import com.demo.productservice.request.price.GetPriceRequest;
import com.demo.productservice.response.price.CreatePriceResponse;
import com.demo.productservice.response.price.GetPriceResponse;
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
 * PriceController
 */
//TODO: using point cut  annotation, have to log the request and response.
@RestController
@RequestMapping("/api/v1")
public class PriceController {
  private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);
  private final Timer productTimer = MetricsUtil
      .registerTimer(getClass().getName(), "price");

  private final CreatePriceHandler createPriceHandler;
  private final GetPriceHandler getPriceHandler;

  @Autowired
  public PriceController(final CreatePriceHandler createPriceHandler,
                         final GetPriceHandler getPriceHandler) {
    this.createPriceHandler = createPriceHandler;
    this.getPriceHandler = getPriceHandler;
  }

  @ApiOperation(value = "Create the product price details.")
  @RequestMapping(value = "/price",
      method = RequestMethod.POST,
      produces = Constants.MEDIA_TYPE_JSON,
      consumes = Constants.MEDIA_TYPE_JSON)
  @ResponseBody
  public ResponseEntity<CreatePriceResponse> createPrice(
      @RequestBody final CreatePriceRequest request) {
    final Timer.Context timer = productTimer.time();
    LOGGER.info(String.format(
        "ProductController.createPrice started for the productId %s", request.getProductId()));
    //TODO: using point cut annotation, have to log the request.
    LOGGER.info("CreatePriceRequest : "+ JsonUtility.objectToJson(request));
    try {
      CreatePriceResponse createPriceResponse = createPriceHandler.handle(request);
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("CreatePriceResponse : "+ JsonUtility.objectToJson(createPriceResponse));
      return new ResponseEntity<>(createPriceResponse, HttpStatus.OK);
    } finally {
      final long elapsedTime = timer.stop();
      LOGGER.info("Time taken to execute createPrice"+elapsedTime);
    }
  }

  @ApiOperation(value = "Get the product price details.")
  @RequestMapping(value = "/price",
      method = RequestMethod.GET,
      produces = Constants.MEDIA_TYPE_JSON,
      consumes = Constants.MEDIA_TYPE_JSON)
  @ResponseBody
  public ResponseEntity<GetPriceResponse> getPrice(@RequestParam(value = "productId") String productId) {
    final Timer.Context timer = productTimer.time();
    LOGGER.info(String.format(
        "ProductController.getPrice started for the productId %s", productId));
    //TODO: using point cut annotation, have to log the request.
    try {
      GetPriceResponse getPriceResponse = getPriceHandler.handle(new GetPriceRequest(productId));
      //TODO: using point cut annotation, have to log the response.
      LOGGER.info("GetPriceResponse : "+ JsonUtility.objectToJson(getPriceResponse));
      return new ResponseEntity<>(getPriceResponse, HttpStatus.OK);
    } finally {
      final long elapsedTime = timer.stop();
      LOGGER.info("Time taken to execute getPrice"+elapsedTime);
    }
  }
}
