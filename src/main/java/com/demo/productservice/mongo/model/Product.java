package com.demo.productservice.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.StringUtils;

import java.util.List;

@Document(collection = "product")
public class Product implements Persistable {
  @Id
  private String id;

  @Field("sellerId")
  private int sellerId;

  @Field("title")
  private String title;

  @Field("manufacturer")
  private String manufacturer;

  @Field("isLowQuantity")
  private boolean isLowQuantity;

  @Field("isSoldOut")
  private boolean isSoldOut;

  @Field("isBackorder")
  private boolean isBackorder;

  @Field("metafields")
  private List<MetaField> metafields;

  @Field("requiresShipping")
  private boolean requiresShipping;

  @Field("isVisible")
  private boolean isVisible;

  @Field("publishedAt")
  private DateType publishedAt;

  @Field("createdAt")
  private DateType createdAt;

  @Field("updatedAt")
  private DateType updatedAt;

  @Field("workFlow")
  private WorkFlow workFlow;

  @Override
  public boolean isNew() {
    return StringUtils.isEmpty(id);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getSellerId() {
    return sellerId;
  }

  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public boolean isLowQuantity() {
    return isLowQuantity;
  }

  public void setLowQuantity(boolean lowQuantity) {
    isLowQuantity = lowQuantity;
  }

  public boolean isSoldOut() {
    return isSoldOut;
  }

  public void setSoldOut(boolean soldOut) {
    isSoldOut = soldOut;
  }

  public boolean isBackorder() {
    return isBackorder;
  }

  public void setBackorder(boolean backorder) {
    isBackorder = backorder;
  }

  public List<MetaField> getMetafields() {
    return metafields;
  }

  public void setMetafields(List<MetaField> metafields) {
    this.metafields = metafields;
  }

  public boolean isRequiresShipping() {
    return requiresShipping;
  }

  public void setRequiresShipping(boolean requiresShipping) {
    this.requiresShipping = requiresShipping;
  }

  public boolean isVisible() {
    return isVisible;
  }

  public void setVisible(boolean visible) {
    isVisible = visible;
  }

  public DateType getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(DateType publishedAt) {
    this.publishedAt = publishedAt;
  }

  public DateType getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateType createdAt) {
    this.createdAt = createdAt;
  }

  public DateType getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateType updatedAt) {
    this.updatedAt = updatedAt;
  }

  public WorkFlow getWorkFlow() {
    return workFlow;
  }

  public void setWorkFlow(WorkFlow workFlow) {
    this.workFlow = workFlow;
  }
}
