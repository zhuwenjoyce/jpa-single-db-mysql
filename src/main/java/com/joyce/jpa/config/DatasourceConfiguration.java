package com.joyce.jpa.config;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {


    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

//    @Value("${datasource.driverClassName}")
//    private String dataSourceDriverClassName;
//
//    @Value("${datasource.jdbcUrl}")
//    private String dataSourceJdbcUrl;

//    @Value("${datasource.username}")
//    private String datasourceUsername;
//
//    @Value("${datasource.password}")
//    private String datasourcePassword;
//
//    @Value("${datasource.connectionTestQuery}")
//    private String datasourceConnectionTestQuery;
//
//    @Value("${datasource.maxTotal}")
//    private Integer datasourceMaxTotal;
//
//    @Value("${datasource.maxIdle}")
//    private Integer datasourceMaxIdle;
//
//    @Value("${datasource.minIdle}")
//    private Integer datasourceMinIdle;
//
//    @Value("${datasource.defaultQueryTimeout.seconds}")
//    private Integer datasourceDefaultQueryTimeoutSeconds;


//    @Bean("dataSource")
//    @ConfigurationProperties("spring.datasource.mysql")
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(dataSourceDriverClassName);
//        dataSource.setUrl(dataSourceJdbcUrl);
//        dataSource.setUsername(datasourceUsername);
//        dataSource.setPassword(datasourcePassword);
//        dataSource.setValidationQuery(datasourceConnectionTestQuery);
//        // connection pool configuration
//        dataSource.setMaxTotal(datasourceMaxTotal);
//        dataSource.setMaxIdle(datasourceMaxIdle);
//        dataSource.setMinIdle(datasourceMinIdle);
//        dataSource.setDefaultQueryTimeout(datasourceDefaultQueryTimeoutSeconds);
//        return dataSource;
//    }

    //主库连接工厂
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(
            EntityManagerFactoryBuilder builder,@Qualifier("dataSource") DataSource dataSource) {
        Map<String, Object> map = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        map.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        return builder
                .dataSource(dataSource)
                .packages("com.joyce.jpa.model")//实体类包名
                .properties(map)
                .persistenceUnit("myPersistenceUnitName")
                .build();
    }

    // 主库事务配置, 这个主事务可以在service层生效：
    // @Transactional(value = "masterTransactionManager")
    // 或者
    // @Transactional(transactionManager = "masterTransactionManager")
    // 因为多数据源，所以得具体指定哪个事务
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager getMasterTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("transactionManager")
    public PlatformTransactionManager getTransactionManager(@Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory.getObject());
//        transactionManager.setGlobalRollbackOnParticipationFailure(true);
        return transactionManager;
    }


}