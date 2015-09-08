package com.spring.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.service.EmployeeService;

@Configuration
@ComponentScan(basePackages="com")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.spring.repository")
public class config {
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource datasource, JpaVendorAdapter jpaVendor){
		LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
		lcemf.setDataSource(datasource);
		lcemf.setJpaVendorAdapter(jpaVendor);
		lcemf.setJpaProperties(jpaProperties());
		return lcemf;
	}
	
	@Bean
	public Properties jpaProperties(){
		Properties prop = new Properties();
		prop.put("eclipselink.weaving", "false");
		return prop;
	}
	
	@Bean
	public EmployeeService employeeService(){
		return new EmployeeService();
	}
	
	@Bean
	public DataSource datasource(){
		BasicDataSource bds = new BasicDataSource();
		bds.setUsername("username");
		bds.setPassword("password");
		bds.setDriverClassName("oracle.jdbc.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@HOST:PORT:SID");
		return bds;
	}
	
	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
	  return new PersistenceAnnotationBeanPostProcessor();
	}
	
	@Bean
	public JpaVendorAdapter jpaVendor(){
		EclipseLinkJpaVendorAdapter eljva = new EclipseLinkJpaVendorAdapter();
		eljva.setDatabase(Database.ORACLE);
		eljva.setShowSql(true);
		eljva.setDatabasePlatform("org.eclipse.persistence.platform.database.oracle.OraclePlatform");
		return eljva;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager platformTransactionManager(){
		return new JpaTransactionManager();
	}
	
}
