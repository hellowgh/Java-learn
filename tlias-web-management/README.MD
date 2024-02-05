# 前后端分离项目

## 功能
- 登录
- 请求过滤、拦截
- CURD
- 全局异常处理
- 文件上传
- 日志功能

## 技术栈
- Spring boot
- Mybatis
- Filter
- Interceptor
- MySQL事务
- JWT
- AOP
- 自定义注解

## sql语句

### operate_log 表
create table operate_log(
  id int auto_increment unsigned primary key comment 'ID',
  operate_user int unsigned comment '操作人ID',
  operate_time datetime comment '操作时间',
  class_name varchar(100) comment '操作的类名',
  method_name varchar(100) comment '操作的方法名',
  method_params varchar(1000) comment '方法参数',
  return_value varchar(2000) comment '返回值',
  cost_time bigint comment '方法执行耗时，单位ms'
) comment '操作日志表';


[视频资料](https://www.bilibili.com/video/BV1m84y1w7Tb?p=140&spm_id_from=pageDriver&vd_source=d6cb596d0a42c992e747c4f524381afb)
