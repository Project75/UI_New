package com.nttdata.fhir.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("com.nttdata.fhir.dao")
@ComponentScan(basePackages = {"com.nttdata.fhir.dao",
                               "com.nttdata.fhir.service"})
public class ServiceConfig {
	
	@Bean
    public DataSource getDataSource() {
       BasicDataSource dataSource = new BasicDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/fhirui");
       dataSource.setUsername("root");
       dataSource.setPassword("W3BU$3rD3V3LopM3nT!");
       return dataSource;
   }
	
   @Bean
   public DataSourceTransactionManager transactionManager() {
       return new DataSourceTransactionManager(getDataSource());
   }
   
   @Bean
   public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      sessionFactory.setDataSource(getDataSource());
      return sessionFactory.getObject();
   }

}
