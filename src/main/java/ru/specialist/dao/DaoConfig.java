package ru.specialist.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("ru.specialist.dao")
@EnableTransactionManagement
public class DaoConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource webDataSource() {
//        Создает одно подключение
//        DriverManagerDataSource ds = new DriverManagerDataSource();
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getRequiredProperty("jdbc.url"));
        ds.setUsername(env.getRequiredProperty("jdbc.username"));
        ds.setPassword(env.getRequiredProperty("jdbc.password"));
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new
                LocalContainerEntityManagerFactoryBean();
        //new org.springframework.orm.jpa.LocalEntityManagerFactoryBean()

        emf.setDataSource(webDataSource());
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("ru.specialist.dao");

        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(emf().getObject());
    }
}
