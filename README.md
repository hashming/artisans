# 匠心社区

## 资料
spring社区：https://spring.io/guides
https://spring.io/guides/gs/serving-web-content/

参考地址：http://localhost:8080/greeting?name=User

github:https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/

bootstrap:https://v3.bootcss.com/components/#navbar-buttons

## 工具

git工具


flyway工具（数据库版本管理软件）
## 建库语句
~~~ sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
~~~


~~~ sql
CREATE TABLE comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT NOT NULL,
    type INT NOT NULL,
    commentator INT NOT NULL,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    like_count BIGINT DEFAULT 0
);
COMMENT ON COLUMN comment.parent_id IS '父类id';
COMMENT ON COLUMN comment.type IS '父类类型';
COMMENT ON COLUMN comment.commentator IS '评论人id';
COMMENT ON COLUMN comment.gmt_create IS '创建时间';
COMMENT ON COLUMN comment.gmt_modified IS '修改时间';
COMMENT ON COLUMN comment.like_count IS '点赞数';
~~~


# thymeleaf调用get请求

### 前端：

```html
<form action="/login" method="post">
    <div class="item">
      <input type="text" th:value="${userName}" name="userName" id="userName" placeholder="请填写用户名">
      <label for="">用户名</label>
    </div>
    <div class="item">
      <input type="password" th:value="${password}" name="password" id="password" placeholder="请填写密码">
      <label for="">密码</label>
    </div>
    <button class="btn">确定
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </button>
 </form>
```

### 后端：

```java
@GetMapping("/login")
    public String userLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String callback(@RequestParam(value = "userName",required = false) String userName,
                           @RequestParam(value = "password",required = false) String password,
                           HttpServletRequest request, HttpServletResponse response) {

        User user = userService.findUser(userName, password);
        if (!ObjectUtils.isEmpty(user)) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            Boolean isSaveStatus = userService.addCookieForCurrentUser(user);
            response.addCookie(new Cookie("token", token));
        }
        return "redirect:/";
    }
```

可以查看这个链接 ： https://blog.csdn.net/fllow_wind/article/details/115764591
