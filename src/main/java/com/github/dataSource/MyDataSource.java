package com.github.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * zhangbo
 */
@Configuration
public class MyDataSource {

    @ConfigurationProperties(prefix = "data")
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        return dataSource;
    }

    @Bean
    public NutDao dao(){
        NutDao dao=new NutDao();
        dao.setDataSource(dataSource());
        return dao;
    }

}
