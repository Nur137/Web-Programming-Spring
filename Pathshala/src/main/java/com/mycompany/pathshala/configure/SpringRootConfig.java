
package com.mycompany.pathshala.configure;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Asif Ahmed
 */
@Configuration
@ComponentScan(basePackages = {"com.mycompany.pathshala.command,com.mycompany.pathshala.controller,com.mycompany.pathshala.dao,com.mycompany.pathshala.daoImpl,com.mycompany.pathshala.rm,com.mycompany.pathshala.services"})
public class SpringRootConfig {
    
    @Bean
    public BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/pathshala");
        ds.setUsername("root");
        ds.setPassword("1235");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
