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
