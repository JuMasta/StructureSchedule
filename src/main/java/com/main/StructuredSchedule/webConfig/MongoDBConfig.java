package com.main.StructuredSchedule.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

	

	@Override
	protected String getDatabaseName() {
		
		return "StructureSchedule";
	}

	@Override
	public MongoClient mongoClient() {
		return  MongoClients.create("mongodb://ec2-18-189-189-212.us-east-2.compute.amazonaws.com:27017");
	}
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(),mappingMongoConverter());
	}

}
