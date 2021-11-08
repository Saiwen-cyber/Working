# springboot + thymeleaf  

由于springboot默认不支持jsp，且纯静态页面开发非常麻烦，因此引入并使用Thymeleaf模板引擎。

#### 官方文档：

[Tutorial: Thymeleaf + Spring](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html)

#### 具体使用(...)

```xml
<!--thymeleaf依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

##### href跳转

###### 跳转controller。

${#mvc.url(('..#...')).build()}

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
语法：
<a th:href="${#mvc.url(('IC#login')).build()}">登陆</a>
<a th:href="${#mvc.url(('IC#login2')).arg(0,1).build()}">getLoginData</a>
注意：此跳转方法只与controller中方法名称有关，与映射路径无关。
```

​	官方文档：[17. Web MVC framework (spring.io)](https://docs.spring.io/spring-framework/docs/4.1.2.RELEASE/spring-framework-reference/html/mvc.html#mvc-links-to-controllers-from-views)

###### 跳转url

@{...}

有不同类型的 URL

1. 绝对 URL：`http://www.thymeleaf.org`

2. 相对 URL，可以是：

   - 页面相对：`user/login.html`
   - 上下文相对：（服务器中的上下文名称将自动添加）`/itemdetails?id=3`
   - 服务器相对： （允许在同一服务器中的另一个上下文 （+ 应用程序） 中调用网线。`~/billing/processInvoice`
   - 协议相对 URL：`//code.jquery.com/jquery-2.0.3.min.js`

   ```html
   <!-- Will produce 'http://localhost:8080/gtvg/order/details?orderId=3' (plus rewriting) -->
   <a href="details.html" 
      th:href="@{http://localhost:8080/gtvg/order/details(orderId=${o.id})}">view</a>
   
   <!-- Will produce '/gtvg/order/details?orderId=3' (plus rewriting) -->
   <a href="details.html" th:href="@{/order/details(orderId=${o.id})}">view</a>
   
   <!-- Will produce '/gtvg/order/3/details' (plus rewriting) -->
   <a href="details.html" th:href="@{/order/{orderId}/details(orderId=${o.id})}">view</a>
   ```

docs:[Tutorial: Using Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#link-urls)

tip：在自定义拦截器时，请求转发记得将要转发至的地址  **过滤**

​		使用registry.addViewController("/login.html").setViewName("login");

