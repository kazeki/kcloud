package com.kzk.kcloud.config;

import com.kzk.kcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
                .tokenKeyAccess("hasAuthority('TRUST_CLIENT')") //TODO:作用不明
                .checkTokenAccess("hasAuthority('TRUST_CLIENT')");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("service-hi")
                .authorizedGrantTypes("client_credentials", "refresh_token", "password")
                .authorities("TRUST_CLIENT")//客户端的权限，标识允许客户端进行的操作，如验证令牌等，
                //客户端预先向服务器申请的Scope列表，也作为缺省默认值，可以在获取Token时指定需要的Scope，但必须是此列表中的Scope
                //Scope用于向用户申请授权，已授权的Scope将写入Token，表示用户允许客户端代替自己进行哪些操作，但同时还会受到用户自己权限的限制
                .scopes("server","read", "write", "trust")
                .secret("secret123")
                .accessTokenValiditySeconds(360000);
    }

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userService);//刷新令牌时用到，不配置会报错
    }

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
}
