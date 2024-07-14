Java案例持续更新中。。。@sxgan

---

> 🏆 事物的发展是螺旋式上升和波浪式前进的， 虽然道路是曲折的，但是前途是光明的。 ———马克思

--- 

# 前言

本仓库主要记录Java相关的案例，包括但不限于SpringBoot、SpringCloud、MyBatis、MyBatis-Plus、MySQL、Redis、RabbitMQ、Quartz、AOP、SpringDoc、Email、定时任务、多数据源、动态切换、切面注解、动态代理、动态代理的实现原理、动态代理的实现

本项目资源文档：[资源文档](a-doc)

本项目涉及的公共依赖：[common-dep](common-dep)

本项目案例涉及的前端统一写在公共模块：[公共前端模块](common-front-pc)‘

前端案例请查看公共前端模块，请点击此处跳转：[README.md](common-front-pc%2FREADME.md)

github仓库地址: [java-example](https://github.com/sxgan-code/java-example)

# 目录

## 基础

- [01-Java基础-集合中的Stream详解](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Fstream)

## SpringBoot整合

- [01-springboot整合-rabbitmq](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Fmq%2Frabbit)
- [02-springboot整合-SpringDoc](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fconfig%2FSpringDocConfig.java)
- [03-springboot整合-quartz定时任务](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Fquartz)
- [04-springboot整合-Email邮件发送](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Femail)
- [05-springboot整合-Redis](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fcache%2Fredis)
- [06-springboot整合-整合EasyExcel](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Fexcel)
- [07-springboot整合-整合Jasypt加密配置](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Futils%2FJasyptUtils.java)

## AOP相关

- [01-AOP之切面注解实现方法耗时日志监控](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Faspect%2FWorkTimeAspect.java)
- [02-AOP之切面注解实现请求参数日志打印](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Faspect%2FRequestLogAspect.java)

## SpringBoot开发案例整合

- [01-权限认证之登录注册功能](java-boot-base%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fbase%2Fauth)

## 数据库相关系列

- [01-多数据源动态切换-手动方式切换](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Fconfig)
- [02-多数据源动态切换-AOP或注解方式切换](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Faspect)
- [03-定时任务批量同步主从数据库](java-boot-db%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fdb%2Fquartz%2FDataTableSyncJob.java)

## 公共工具类

- [01-全局响应结果对象](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fresponse)
- [02-全局异常拦截处理](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fexception)
- [03-全局请求拦截处理](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Finterceptor)
- [04-跨域处理](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Fconfig%2FCorsConfig.java)
- [05-实时监听文件改动工具类](common-dep%2Fsrc%2Fmain%2Fjava%2Fcn%2Fsxgan%2Fcommon%2Futils%2FWatchFileUtils.java)
