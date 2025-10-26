[![zread](https://img.shields.io/badge/Ask_Zread-_.svg?style=for-the-badge&color=00b0aa&labelColor=000000&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyB3aWR0aD0iMTYiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxNiAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTQuOTYxNTYgMS42MDAxSDIuMjQxNTZDMS44ODgxIDEuNjAwMSAxLjYwMTU2IDEuODg2NjQgMS42MDE1NiAyLjI0MDFWNC45NjAxQzEuNjAxNTYgNS4zMTM1NiAxLjg4ODEgNS42MDAxIDIuMjQxNTYgNS42MDAxSDQuOTYxNTZDNS4zMTUwMiA1LjYwMDEgNS42MDE1NiA1LjMxMzU2IDUuNjAxNTYgNC45NjAxVjIuMjQwMUM1LjYwMTU2IDEuODg2NjQgNS4zMTUwMiAxLjYwMDEgNC45NjE1NiAxLjYwMDFaIiBmaWxsPSIjZmZmIi8%2BCjxwYXRoIGQ9Ik00Ljk2MTU2IDEwLjM5OTlIMi4yNDE1NkMxLjg4ODEgMTAuMzk5OSAxLjYwMTU2IDEwLjY4NjQgMS42MDE1NiAxMS4wMzk5VjEzLjc1OTlDMS42MDE1NiAxNC4xMTM0IDEuODg4MSAxNC4zOTk5IDIuMjQxNTYgMTQuMzk5OUg0Ljk2MTU2QzUuMzE1MDIgMTQuMzk5OSA1LjYwMTU2IDE0LjExMzQgNS42MDE1NiAxMy43NTk5VjExLjAzOTlDNS42MDE1NiAxMC42ODY0IDUuMzE1MDIgMTAuMzk5OSA0Ljk2MTU2IDEwLjM5OTlaIiBmaWxsPSIjZmZmIi8%2BCjxwYXRoIGQ9Ik0xMy43NTg0IDEuNjAwMUgxMS4wMzg0QzEwLjY4NSAxLjYwMDEgMTAuMzk4NCAxLjg4NjY0IDEwLjM5ODQgMi4yNDAxVjQuOTYwMUMxMC4zOTg0IDUuMzEzNTYgMTAuNjg1IDUuNjAwMSAxMS4wMzg0IDUuNjAwMUgxMy43NTg0QzE0LjExMTkgNS42MDAxIDE0LjM5ODQgNS4zMTM1NiAxNC4zOTg0IDQuOTYwMVYyLjI0MDFDMTQuMzk4NCAxLjg4NjY0IDE0LjExMTkgMS42MDAxIDEzLjc1ODQgMS42MDAxWiIgZmlsbD0iI2ZmZiIvPgo8cGF0aCBkPSJNNCAxMkwxMiA0TDQgMTJaIiBmaWxsPSIjZmZmIi8%2BCjxwYXRoIGQ9Ik00IDEyTDEyIDQiIHN0cm9rZT0iI2ZmZiIgc3Ryb2tlLXdpZHRoPSIxLjUiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K&logoColor=ffffff)](https://zread.ai/Shihaoooo/tlias-management-back-end)

# Tlias Web Management Backend

一个基于Spring Boot的企业级后台管理系统后端项目，提供完整的员工、部门、班级和学生管理功能。

## 项目概述

Tlias Web Management 是一个现代化的企业级后台管理系统，采用主流的Java技术栈开发，具备完善的权限认证、数据管理和文件处理能力。

## 技术栈

- **后端框架**: Spring Boot 3.4.5
- **Java版本**: Java 17
- **数据库**: MySQL 8.0
- **ORM框架**: MyBatis 3.0.4
- **认证授权**: JWT Token
- **文件存储**: 阿里云OSS
- **分页插件**: PageHelper
- **日志框架**: Logback
- **构建工具**: Maven

## 项目结构

```
tlias-web-management/
├── src/main/java/com/itheima/
│   ├── controller/          # 控制器层
│   ├── service/            # 业务逻辑层
│   ├── mapper/             # 数据访问层
│   ├── pojo/               # 实体类
│   ├── config/             # 配置类
│   ├── utils/              # 工具类
│   ├── filter/             # 过滤器
│   ├── interceptor/        # 拦截器
│   └── Exception/          # 异常处理
├── src/main/resources/
│   ├── application.yml     # 应用配置
│   ├── logback.xml         # 日志配置
│   └── templates/          # 模板文件
└── sql/                    # 数据库脚本
```

## 核心功能

### 👥 员工管理
- 员工信息CRUD操作
- 员工工作经历管理
- 员工统计分析
- 员工分页查询与条件筛选

### 🏢 部门管理
- 部门组织架构管理
- 部门信息维护

### 📚 班级管理
- 班级信息管理
- 班级数据统计

### 👨‍🎓 学生管理
- 学生信息管理
- 学历学位映射
- 学生统计分析

### 🔐 认证授权
- 基于JWT的用户认证
- Token拦截器验证
- 登录登出管理

### 📁 文件管理
- 阿里云OSS文件上传
- 头像图片处理
- 文件下载功能

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- 阿里云OSS账号（可选）

### 安装步骤

1. **克隆项目**
```bash
git clone https://github.com/Shihaoooo/tlias-management-back-end.git
```

2. **配置数据库**
```bash
# 创建数据库
CREATE DATABASE tlias;

# 执行SQL脚本
cd tlias-web-management/sql
# 按顺序执行：
# - clazz.sql
# - degreeMapping.sql  
# - emp.sql
# - stu.sql
# - subjectMapping.sql
```

3. **修改配置文件**
编辑 [src/main/resources/application.yml](tlias-web-management/src/main/resources/application.yml)：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/tlias
    username: your_username
    password: your_password

aliyun:
  oss:
    endpoint: https://oss-cn-beijing.aliyuncs.com
    bucketName: your_bucket_name
    region: cn-beijing
```

4. **启动项目**
```bash
cd tlias-web-management
mvn spring-boot:run
```

5. **访问接口**
- 应用启动后默认端口：8080
- 登录接口：POST `/login`
- 员工管理：`/emps`
- 部门管理：`/depts`

## API文档

主要接口说明：

### 认证相关
- `POST /login` - 用户登录
- `POST /logout` - 用户登出

### 员工管理
- `GET /emps` - 分页查询员工列表
- `POST /emps` - 新增员工
- `PUT /emps/{id}` - 修改员工信息
- `DELETE /emps/{ids}` - 删除员工
- `GET /emps/{id}` - 查询员工详情

### 其他模块
- 部门管理：`/depts`
- 班级管理：`/clazzs`
- 学生管理：`/stus`
- 文件上传：`/upload`
- 报表统计：`/reports`

## 配置说明

### 数据库配置
项目使用MyBatis作为ORM框架，支持驼峰命名转换和SQL日志输出。

### JWT配置
```yaml
jwt:
  secret: a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8
  expire: 3600000  # Token过期时间（毫秒）
```

### 阿里云OSS配置
需要配置阿里云OSS的endpoint、bucketName和region信息。

## 开发规范

### 代码结构
- 采用经典的三层架构模式
- Controller层负责接收请求和参数验证
- Service层处理业务逻辑
- Mapper层处理数据访问

### 异常处理
使用全局异常处理器统一处理各类异常，返回统一的响应格式。

### 日志规范
使用Logback进行日志管理，支持不同级别的日志输出。

## 部署说明

### 传统部署
```bash
# 打包
mvn clean package

# 运行
java -jar target/tlias-web-management-0.0.1-SNAPSHOT.jar
```
---

**注意**：这是一个学习项目，仅供参考和交流使用。
