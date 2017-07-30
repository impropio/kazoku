package com.francisco.kazoku.web.core.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuracion de la base de datos cuando se usa JPA o SptingData JPA.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseJpaConfig {
    
    @Value("${basedatos.datasource.driverClassName}")
    private String driver;
    
    @Value("${basedatos.datasource.url}")
    private String url;
    
    @Value("${basedatos.datasource.username}")
    private String usuario;
    
    @Value("${basedatos.datasource.password}")
    private String clave;
    
    @Value("${basedatos.showSql}")
    private String mostrarSql;
    
    @Value("${basedatos.actualiza.entities}")
    private String actualizaEntities;
    
    @Value("${basedatos.dialecto}")
    private String dialecto;
    
    @Value("${basedatos.ruta.entities}")
    private String rutaEntities;
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {rutaEntities});
        
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        
        return em;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(usuario);
        dataSource.setPassword(clave);
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        
        return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    Properties additionalProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", actualizaEntities);
        properties.setProperty("hibernate.show_sql", mostrarSql);
        properties.setProperty("hibernate.dialect", dialecto);
        return properties;
    }
    
}