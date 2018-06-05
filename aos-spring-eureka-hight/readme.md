Eureka 高可用配置

1. 先在host文件(C:\windows\system32\drivers\etc)配置3个域名,  
   127.0.0.1 peer1 peer2 peer3
2. 配置文件application.yml, 有多个配置, 启动应用时要指定使用哪个配置

spring:
  application:
    name: Eureka-Hight

security:
  basic:
    enabled: true
  user:
    name: user
    password: aosco

---
server:
  port: 8761
spring:
  profiles: peer1     #配置名称
eureka:
  instance:
    hostname: peer1
  client:
    serviceUrl:
      defaultZone: http://user:aosco@peer2:8762/eureka/

---
server:
  port: 8762
spring:
  profiles: peer2     #配置名称
eureka:
  instance:
    hostname: peer2
  client:
    serviceUrl:
      defaultZone: http://user:aosco@peer1:8761/eureka/