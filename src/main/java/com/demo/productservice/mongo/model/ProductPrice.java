package com.demo.productservice.mongo.model;

import com.demo.productservice.request.price.Price;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.StringUtils;

@Document(collection = "productprice")
public class ProductPrice implements Persistable {
  @Id
  private String id;

  @Field("productId")
  private String productId;

  @Field("price")
  private Price price;

  @Override
  public boolean isNew() {
    return StringUtils.isEmpty(id);
  }

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }
}
