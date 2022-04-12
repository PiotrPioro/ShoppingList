package com.example.shoppinglist;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.shoppinglist.repository")
@EnableTransactionManagement
public class AppConfig {
}
