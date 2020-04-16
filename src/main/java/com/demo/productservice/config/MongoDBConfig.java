package com.demo.productservice.config;

import java.util.Collection;
import java.util.Collections;

import com.demo.productservice.mongo.dao.ProductRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@PropertySource("file:src/main/resources/application.yml")
@EnableMongoRepositories(basePackageClasses = ProductRepository.class ,mongoTemplateRef = "mongoTemplate")
@EnableMongoAuditing
public class MongoDBConfig extends AbstractMongoClientConfiguration {

	@Value("${mongo.database}")
	private String database;

	@Value("${mongo.uri}")
	private String dbUrl;

	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	public MongoClient mongoClient() {
		return MongoClients.create(dbUrl);
	}

	@Bean(name="mongoTemplate")
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), getDatabaseName());
		
		return mongoTemplate;
	}

	@Override
	protected Collection<String> getMappingBasePackages() {
		return   Collections.singleton(ProductRepository.class.getPackage().getName());
	}

}