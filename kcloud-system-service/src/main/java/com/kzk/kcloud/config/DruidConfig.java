package com.kzk.kcloud.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig{

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
