Java案例持续更新中。。。@sxgan

---

> 🏆 事物的发展是螺旋式上升和波浪式前进的， 虽然道路是曲折的，但是前途是光明的。 ———马克思

--- 

# 前言

本仓库主要记录Java相关的案例，包括但不限于SpringBoot、SpringCloud、MyBatis、MyBatis-Plus、MySQL、Redis、RabbitMQ、Quartz、AOP、SpringDoc、Email、定时任务、多数据源、动态切换、切面注解、动态代理、动态代理的实现原理、动态代理的实现

本项目资源文档：[资源文档](a-doc)

github仓库地址: [java-example](https://github.com/sxgan-code/java-example)

# 目录

## 公共工具类

- [01-全局响应结果对象](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fresponse)
- [02-全局异常拦截处理](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fexception)

## springboot整合

- [01-springboot整合-rabbitmq](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Fmq%2Frabbit)
- [02-springboot整合-SpringDoc](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fconfig%2FSpringDocConfig.java)
- [03-springboot整合-quartz定时任务](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Fquartz)
- [04-springboot整合-Email邮件发送](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Femail)

## AOP相关

- [01-AOP之切面注解实现方法耗时日志监控](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Faspect%2FWorkTimeAspect.java)

## 数据库相关系列

- [01-多数据源动态切换-手动方式切换](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Fconfig)
- [02-多数据源动态切换-AOP或注解方式切换](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Faspect)
- [03-定时任务批量同步主从数据库](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Fquartz%2FDataTableSyncJob.java)