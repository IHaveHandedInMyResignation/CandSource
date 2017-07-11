package com.cand.source.webconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class DataSourceConfig {
	
	@Value("${jndi.dataSource}") 
	private String dataSourcePath;
	
	@Value("${hibernate.dialect}") 
	private String hibernateDialect;
	
	@Bean
	public DataSource dataSource(){
		final JndiDataSourceLookup jndiSource = new JndiDataSourceLookup();
	
		DataSource dataSource = jndiSource.getDataSource(dataSourcePath);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
		LocalSessionFactoryBean sfb= new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan(new String[] {"com.cand.source.persistentce"});
		sfb.setHibernateProperties(hibernateProperties());
		return sfb;
	}
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.id.new_generator_mappings","false");
        return properties;        
    }
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
