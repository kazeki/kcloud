package com.kzk.kcloud.config;
//
//import com.kzk.spsec.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
//@Configuration
//@EnableWebSecurity //开启WebSecurity配置
//@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法级别权限注解
//public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserService userService;
//
//    /**
//     * 配置身份认证用的用户数据来源等细节
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //测试用代码，内存中创建用户及权限数据，注意：.roles和.authorities()不要在同一个用户上使用，后调用的会覆盖之前调用的结果
////        auth.inMemoryAuthentication().withUser("kazeki").password("kazeki").roles("USER");
////        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.userDetailsService(userService);//.passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    /**
//     * 配置请求安全验证拦截规则
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//        http
//                .anonymous().disable()
//                .authorizeRequests()//注意：下面这些访问权限设置的顺序，前面的优先级高，所以"/**"这种要设置在后面
//                .antMatchers("/my/**").access("hasAuthority('USER')")
//                .antMatchers("/admin/**").access("hasAuthority('ADMIN')")
//                .antMatchers("/api/**").access("hasAuthority('API')")
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(new OAuth2AccessDeniedHandler())
////                .and()
////                .formLogin()
//                .and()
//                .csrf().disable(); //CSRF(Cross-site request forgery)跨站请求伪造
//
////        http
////                .authorizeRequests().anyRequest().authenticated().and().csrf().disable();
//    }
//
//    @Override
//    @Bean //WebSecurityConfigurerAdapter提供了构造AuthenticationManager的方法，但向Spring提交这个Bean，用户根据需要使用
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
//
//
//
//
