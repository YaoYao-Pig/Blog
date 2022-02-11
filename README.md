# Blog
# 一个简单的博客项目
## 前端框架：
  + Semantic UI，thymeleaf
  + 零散的一些组件，包括简单的动画效果
## 后端：
  + 使用SpringBoot作为框架
## 持久化：
  + JPA
  + MySql

# 实现功能：
  + 简单的CRUD
  + 多级评论
  + 简单的插件整合，支持MarkDown
  + 后台的文章发布和管理
  + 利用Jpa和封装的Sql语句进行数据库读写
# 未实现功能/Bug
  + 全局的文章搜索
  + 评论分级显示存在问题
  + 部分功能存在无法使用的问题
  + 用户注册
  + 前后端分离
# 内部组成介绍：
## 采用SpringBoot的MVC架构
## 实体类分别针对Blog，Comment，User，Type，Tag
## Mysql文件夹下存放Sql文件

