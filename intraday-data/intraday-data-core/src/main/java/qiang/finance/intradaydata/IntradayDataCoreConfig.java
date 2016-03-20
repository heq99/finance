package qiang.finance.intradaydata;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

/**
 * Created by Qiang He on 03/03/2016.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan
@PropertySource("classpath:conf/datasource.properties")
public class IntradayDataCoreConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean  = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean .setDataSource(dataSource());
        entityManagerFactoryBean .setPackagesToScan("qiang.finance.intradaydata.entities");

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setShowSql(false);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        jpaVendorAdapter.setDatabase(Database.MYSQL);

        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        txManager.setJpaDialect(new HibernateJpaDialect());
        return txManager;
    }

}
