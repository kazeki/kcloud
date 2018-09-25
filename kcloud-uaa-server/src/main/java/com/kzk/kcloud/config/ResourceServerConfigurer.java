package com.kzk.kcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests()//注意：下面这些访问权限设置的顺序，前面的优先级高，所以"/**"这种要设置在后面
                .antMatchers("/my/**").access("hasAuthority('USER')")
                .antMatchers("/admin/**").access("hasAuthority('ADMIN')")
                .antMatchers("/api/**").access("hasAuthority('API')")
                .and()
                .csrf().disable(); //CSRF(Cross-site request forgery)跨站请求伪造
    }
}
