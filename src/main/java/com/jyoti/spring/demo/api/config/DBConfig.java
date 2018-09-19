package com.jyoti.spring.demo.api.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = "classpath:application.properties")
@Configuration
public class DBConfig {
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(setHibernateProperties());
		factory.setPackagesToScan(new String[] {"com.jyoti.spring.demo.api.model"});
		return factory;
		
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}

	private Properties setHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", dialect);
		prop.put("hibernate.format_sql", "true");
		return prop;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager txnManager = new HibernateTransactionManager();
		txnManager.setSessionFactory(factory);
		return txnManager;
	}

}
