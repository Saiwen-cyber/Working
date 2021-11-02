# springboot + thymeleaf  

由于springboot默认不支持jsp，且纯静态页面开发非常麻烦，因此引入并使用Thymeleaf模板引擎。

##### 官方文档：

[Tutorial: Thymeleaf + Spring](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html)

##### 具体使用(...)

```xml
<!--thymeleaf依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

- ###### **href跳转**

  ```java
  @Controller
  public class IndexController {
  
    	//不带参数  
      @RequestMapping("/login")
      public String login() {
          ...
          return "login";
      }
      //带参数
      @RequestMapping("/getLoginData")
      public String login2(@RequestParam Integer userId) {
          ...
          return "login";
      }
  }
  ```
  
  ```html
  <a th:href="${#mvc.url(('IC#login')).build()}">登陆</a>
  <a th:href="${#mvc.url(('IC#login2')).arg(0,1).build()}">getLoginData</a>
  ```
  
  ​	官方文档：[17. Web MVC framework (spring.io)](https://docs.spring.io/spring-framework/docs/4.1.2.RELEASE/spring-framework-reference/html/mvc.html#mvc-links-to-controllers-from-views)

tip：在自定义拦截器时，请求转发记得将要转发至的地址  **过滤**

​		使用registry.addViewController("/login.html").setViewName("login");