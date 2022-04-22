create table login_user
(
    id int auto_increment,
    userName varchar(30) null comment '用户名',
    password int null comment '用户密码',
    token varchar(50) null comment '用户token',
    constraint login_user_pk
        primary key (id)
)
    comment '用户表';