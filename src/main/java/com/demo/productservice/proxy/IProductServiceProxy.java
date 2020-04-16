/**
 * Copyright 2016 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.demo.productservice.proxy;

import com.demo.productservice.response.price.GetPriceResponse;
import com.demo.productservice.response.product.GetProductResponse;

import java.util.concurrent.CompletableFuture;

public interface IProductServiceProxy {

  //TODO: add annotations to lof the proxy request and responses using point cut notations
  CompletableFuture<GetProductResponse> getProduct(String productId);

  //TODO: add annotations to lof the proxy request and responses using point cut notations
  CompletableFuture<GetPriceResponse> getPrice(String productId);

}
