package com.raccoon.learnapp.student.impl.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.raccoon.learnapp.student.impl.dao")
@Configuration
public class PersistenceJPAConfig {
}
