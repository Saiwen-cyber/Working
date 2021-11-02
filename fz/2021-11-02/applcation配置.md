

### springboot 整合mybatis

官方文档：http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.0</version>
</dependency>
```

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

application.yml

```yaml
spring:
  messages:
    basename: i18n.login #多语言环境
  thymeleaf:
    cache: false
  datasource:
    url: jdbc:mysql://localhost:3306/springboot_train?useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource #自定义数据源
    #druid专有属性，需要自己绑定
    initialSize: 6
    #...
    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    filters: stat,wall,log4j
    #导入log4j的依赖
mybatis:
  configuration:
    map-underscore-to-camel-case: true
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.fangzhe.pojo
```



```java
/**
 * 部分接管springMvc
 * @author ASUS
 */
@Configuration
public class MyWebmvcConfiguration implements WebMvcConfigurer {
	
    /**
     * 将spring.datasource中的同名属性注入到DruidDataSource中
    */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
      return new DruidDataSource();
    }
}
```

