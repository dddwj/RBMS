# RBMS 参考书管理系统
> 《数字图书馆课程设计》课程成果 

## 主要功能
1. 教师登录教务系统后，可以根据学年、学期查询自己相关课程的开课信息，并且提供对应课程“添加教参”的链接。
2. 据查询的到课程，教师可以看到该课程对应的教参信息。
3. 添加教参信息：教师通过输入教材的ISBN、书名、作者等信息查询到图书馆相关的书目，并可以选择需要的图书添加入课程教参中。
4. 对图书馆没有馆藏的教材图书，提供教参信息录入窗口让教师自行添加信息，并可申请数字化教材采购。

## 运行
- Chrome/Safari/Firefox浏览器
- demo: http://rbms.wj-ecust.xyz:8080/
	- 学生账号：10161866  密码：123
	- 教师账号：111  密码：111

## 开发工具
- IntelliJ IDEA
- Maven
- Navicat for MySQL
- Sublime Text

## 开发环境
- Java 1.8
- Spring Boot 2.1.5
- Thymeleaf 
- MyBatis 2.0.1
- MySQL 5.6
- Druid 1.1.17
- Bootstrap 3.3.7
- Bootstrap-table
- jQuery 2.1.1

## 编译运行
- Maven安装依赖并打包
- `nohup java -jar /root/rbms/utms-0.0.1-SNAPSHOT.jar --file.upload-folder=/root/rbms/static/userfiles/`
- 可能需要科学上网 （加载`font-awesome.min.css`）
