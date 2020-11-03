//package com.joyce.jpa.config;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// must import dependency:
// <dependency>
//     <groupId>org.apache.commons</groupId>
//     <artifactId>commons-dbcp2</artifactId>
//     <version>2.7.0</version>
// </dependency>
//
// Hikari VS Dbcp throughput:  771/s VS 423/s
//
// * @author: Joyce Zhu
// * @date: 2020/11/3
// */
//@Configuration
//public class ConfigDbcpDataSource {
//
//
//    @Value("${datasource.driverClassName}")
//    private String dataSourceDriverClassName;
//
//    @Value("${datasource.jdbcUrl}")
//    private String dataSourceJdbcUrl;
//
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
//
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
//
//}
