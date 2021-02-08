package com.cinemaprime.backend.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {
    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://cinemaprime:MeinKinoIstSicher@cluster0.uris2.mongodb.net/cinemaprime?retryWrites=true&w=majority");
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "cinemaprime");
    }
}
