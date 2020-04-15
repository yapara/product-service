package com.demo.productservice.request.product;

import com.demo.productservice.request.Constants;
import com.demo.productservice.request.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class UpdateProductRequest extends BaseRequest implements Serializable {
  private static final long serialVersionUID = 6997185285305564078L;

  private String productId;

  @ApiModelProperty(value = Constants.DOC_SELLER_ID, required = true)
  private int sellerId;

  private String title;

  private String manufacturer;

  private boolean isLowQuantity;

  private boolean isSoldOut;

  private boolean isBackorder;

  private List<MetaField> metafields;

  private boolean requiresShipping;

  private boolean isVisible;

  private DateType publishedAt;

  private DateType createdAt;

  private DateType updatedAt;

  private WorkFlow workFlow;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
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
