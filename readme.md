## 端口分配 ##
eureka: 8761  
config: 8769  

## 基础架构 ##
不同环境（开发环境、测试环境、生产环境）都应该有独立的配置中心(ConfigCenter)、服务注册中心（EurekaServer）；

配置中心自身的配置，一些敏感信息如Git仓库的地址及用户名密码等，应该从环境变量传入，其他配置可以从Git仓库取得；
配置中心注册到服务注册中心，作为微服务实现高可用；
所有应用的配置都从对应环境的配置中心取得（包括服务注册中心）；
服务注册中心启动时连接配置中心的URL从环境变量传入，从配置中心获取配置覆盖本地配置后也是用服务方式调用配置中心（需要注意的是EurekaServer也需要获取服务列表，即eureka-client-fetchRegistry=true）
除服务注册中心外，其他应用通过服务调用的方式访问配置中心；

先启动ConfigCenter，ConfigCenter取到对应环境的配置后，向指定环境的EurekaServer注册自己；
此时EurekaServer还没有启动，ConfigCenter虽然启动成功了但是无法完成注册，但是它会定时轮询注册中心，一旦注册中心就绪了，配置中心也就马上注册上去了；


## 目前的问题： ##
如果使用配置中心的/refresh端口刷新配置中心的配置，配置中心会从服务注册中心下线，并且配置更新完之后无法重新上线。
（日志显示EurekaClient被shutdown，之后没有启动的日志）
貌似当EurekaServer的spring-cloud-config-fail-fast=false的时候，虽然配置中心服务已经下线，但是仍然可以通过注册中心的/refresh端点刷新注册中心的配置，反之如果是true，则刷新时会出现500错误

