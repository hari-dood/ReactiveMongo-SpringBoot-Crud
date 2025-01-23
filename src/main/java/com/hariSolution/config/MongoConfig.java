package com.hariSolution.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public class MongoConfig {

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }

    @Bean
    public String getDataBaseName(){
        return "employee";
    }
    @Bean
    public ReactiveMongoTemplate mongoTemplate(){
        return new ReactiveMongoTemplate(mongoClient(),getDataBaseName());
    }
}
