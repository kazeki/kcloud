package com.kzk.kcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfigurer {

    private final Log logger = LogFactory.getLog(DruidConfigurer.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource") //直接通过属性文件注入到DruidDataSource会有问题，所以用间接方式
    DruidDataSourceProperties druidDataSourceProperties(){
        DruidDataSourceProperties druidDataSourceProperties = new DruidDataSourceProperties();
        return druidDataSourceProperties;
    }

    @Bean
    DataSource dataSource(DruidDataSourceProperties prop){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(prop.getUrl());
        datasource.setUsername(prop.getUsername());
        datasource.setPassword(prop.getPassword());
        datasource.setDriverClassName(prop.getDriverClassName());
        datasource.setInitialSize(prop.getInitialSize());
        datasource.setMinIdle(prop.getMinIdle());
        datasource.setMaxActive(prop.getMaxActive());
        //datasource.setDbType(prop.getType());
        datasource.setMaxWait(prop.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(prop.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(prop.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(prop.getValidationQuery());
        datasource.setTestWhileIdle(prop.isTestWhileIdle());
        datasource.setTestOnBorrow(prop.isTestOnBorrow());
        datasource.setTestOnReturn(prop.isTestOnReturn());
        try {
            datasource.setFilters(prop.getFilters());
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

    @Bean
    @ConfigurationProperties(prefix = "druid.servlet")
    ServletRegistrationBean druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> params = new HashMap<>();
        bean.setInitParameters(params);
        return bean;
    }

    //用于监听获取应用的数据 ， Filter用于收集数据, Servlet用于展现数据
    @Bean
    @ConfigurationProperties(prefix = "druid.webfilter")
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter()); //设置过滤器
        bean.addUrlPatterns("/*");
        Map<String,String> param = new HashMap<String,String>();
        //排除静态资源
        param.put("exclusions" , "*.png,*.woff,*.js,*.css,/druid/*");
        bean.setInitParameters(param);
        return bean;
    }
}
