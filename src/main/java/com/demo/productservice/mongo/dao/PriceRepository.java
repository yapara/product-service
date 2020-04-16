package com.demo.productservice.mongo.dao;

import com.demo.productservice.mongo.model.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<ProductPrice, String> {
}
