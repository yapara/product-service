package com.demo.productservice.mongo.dao;

import com.demo.productservice.mongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
