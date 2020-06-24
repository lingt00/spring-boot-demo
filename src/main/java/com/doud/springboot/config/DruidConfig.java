package com.doud.springboot.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    Logger logger = LoggerFactory.getLogger(getClass());

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        logger.info("*********使用Druid数据源***********");
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控
     * 1、配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        logger.info("*********配置Druid管理后台的Servlet***********");

        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParam = new HashMap<>();
        initParam.put("loginUsername","admin");
        initParam.put("loginPassword","123456");
        initParam.put("allow","");//默认就是允许所有访问
        bean.setInitParameters(initParam);
        return bean;
    }

    /**
     * 配置一个Web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        logger.info("*********配置Druid管理后台的Filter***********");

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
