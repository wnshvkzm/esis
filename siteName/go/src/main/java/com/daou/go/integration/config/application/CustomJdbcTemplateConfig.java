package com.daou.go.integration.config.application;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.quartz.TriggerKey;
import org.quartz.TriggerListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import com.daou.go.config.application.DataSourceConfigException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:META-INF/datasource-development.properties")
@EnableTransactionManagement
public class CustomJdbcTemplateConfig {

    private static final int MINUTE_5 = 300;

    @Value("${custom.db.host}")
    private String host;
    
    @Value("${custom.db.port}")
    private String port;

    @Value("${custom.db.name}")
    private String dbName;

    @Value("${custom.db.username}")
    private String userName;

    @Value("${custom.db.password}")
    private String password;

    @Value("${custom.db.driver}")
    private String driver;

    @Value("${custom.db.url.protocol}")
    private String protocol;

    @Value("${custom.conn.pool.init}")
    private int initialPoolSize;

    @Value("${custom.conn.pool.min}")
    private int minPoolSize;

    @Value("${custom.conn.pool.max}")
    private int maxPoolSize;

    @Bean(destroyMethod = "close")
    public DataSource customDataSource() {
        ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            pool.setDriverClass(driver);
            pool.setJdbcUrl(getJdbcUrl());
            pool.setUser(userName);
            pool.setPassword(password);
            pool.setInitialPoolSize(initialPoolSize);
            pool.setMinPoolSize(minPoolSize);
            pool.setMaxPoolSize(maxPoolSize);
            pool.setIdleConnectionTestPeriod(MINUTE_5);
            pool.setPreferredTestQuery("SELECT 1 FROM DUAL");
            return pool;
            
        } catch (PropertyVetoException pve) {
            throw new DataSourceConfigException(pve);
        }
    }

    @Bean
    public JdbcTemplate customJdbcTemplate() {
        return new JdbcTemplate(customDataSource());
    }

    private String getJdbcUrl() {
        StringBuffer url = new StringBuffer();
        
        url.append(protocol);
        url.append("://");
        url.append(host);
        url.append(':');
        url.append(port);
        url.append(";DatabaseName=");
        url.append(dbName);
        
        return url.toString();
    }
}
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													