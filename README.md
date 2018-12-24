# copyTim
前端：vue.js；后端：SpringBoot；
这个项目是模仿tim建立的一个javaWeb项目


持久层使用了Mybaties,
数据库使用了MySql,
安全框架使用Apache的Shiro,
缓存使用redis，
集成activiti，
公共库使用maven,

项目中可以存在jsp页面详情请见目录：/yaoProject-1/src/main/webapp/view
项目结构：

|-- yaoProject-1                                // 项目根目录<br/>
|   |-- src/main/java  <br/>                               
|   |   |-- action       <br/>                             
|   |   |   |-- GenerateCodeTest.java           // 反向生成类--在src/main/resource中有对应的配置文件generatorConfig.xml<br/>
|   |   |   |-- ServletInitializer.java<br/>
|   |   |   |-- YaoProject2Application.java     //SpringBoot的核心类(里面有一些配置，启动项目直接右键=>Run As=>java Application)<br/>
|   |   |-- base    <br/>
|   |   |   |-- RESTful               //自己封装的用于控制器中返回<br/>
|   |   |   |-- shiro                 //shiro配置类等，类上面有注解<br/>
|   |   |-- controller                //控制器 <br/>
|   |   |-- entity                    //实体 <br/>
|   |   |-- mapper                    //dao层（持久层） <br/>
|   |   |-- service                   //业务逻辑层<br/>
|   |-- src/main/java  <br/>
|   |   |-- mapper                    //dao层（持久层）的.xml <br/>
|   |   |-- static                    //页面中的静态资源<br/>
|   |   |-- application.yml           //SpringBoot的配置文件<br/>
|   |   |-- CreateTable.sql           //建表语句<br/>
|   |-- src/main/java <br/>
|   |-- src/main/webapp/view          //页面<br/>
---未完待续```






#### 安装教程

安装jdk 1.8.0_91
安装mysql
向数据库导入所需表（在目录yaoProject-2/src/main/resources/CreateTable.sql）注意配置文件application.yml中的数据库名称,用户名，及密码
项目访问地址：http://localhost:8888/yao



#### 使用说明

1. 后端项目中支持使用: .jsp或.html ，注意使用html时需要修改配置文件application.yml中的mvc view:suffix:.html
2.
3.作为VUE Api时需要注意------
（1）. controller中返回对象com.yaoxx.base.RESTful.Result为个人封装对象
（2）. 由于需要跨域请求控制器上需要添加注解@CrossOrigin
（3）. 若为前后端分离项目记得将控制器上添加注解@ResponseBody @Controller（或者直接添加@RestController）

