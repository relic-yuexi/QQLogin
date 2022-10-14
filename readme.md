# JavaFX仿QQ登录界面
---
简介：一个使用JavaFx仿制的QQ登录界面
version: 0.2

---
## 1. 项目介绍
### 1.1 项目背景
本项目是一个使用JavaFX仿QQ登录界面的软件，主要是为了学习JavaFX的使用，以及学习一些JavaFX的布局方式。

### 1.2 项目功能

    * 登录界面
    * 注册界面
    * 忘记密码界面
    * 主界面

### 1.3 项目技术

    * JavaFX
    * CSS
    * Java
    * Maven

### 1.4 项目结构

## 项目展示

![image](https://cdn.jsdelivr.net/gh/relic-yuexi/QQLogin@main/doc/media/base-demo.gif)






## ToDoLsit
- [ ] 代码注释

- [ ] 项目介绍/文档

- [x] 项目截图

- [ ] 项目结构

- [ ] 项目运行

- [x] 项目打包

- [ ] 项目发布

## 更新日志

### 0.2

添加JavaPackager打包工具，可以成功打包成exe文件

JavaPackager打包工具的地址
https://github.com/fvarrui/JavaPackager

JavaPackager打包工具的使用

首先在pom.xml中添加JavaPackager的依赖，这里仅提供我的配置，自己可以根据相应的配置进行修改

```xml
            <plugin>
                <groupId>io.github.fvarrui</groupId>
                <artifactId>javapackager</artifactId>
                <version>1.6.7</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>package</goal>
                        </goals>
                        <configuration>
                            <!-- mandatory -->
                            <mainClass>com.moontidef.qqlogin.Main</mainClass>
                            <!-- optional -->
                            <bundleJre>true</bundleJre>
                            <generateInstaller>false</generateInstaller>
                            <platform>auto</platform>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```

然后在IDEA中，点击Maven->执行Maven目标（是一个小图标）->输入mvn clean package -> OK

坑：项目的文件结构不能直接是默认的xxApplication + xxController的形式，需要新建一个Main类，然后在Main类中调用xxApplication.main(args)方法，注意在xxApplication类里面要有相应的main方法，然后在pom.xml中配置mainClass为Main类的路径，不然会无法运行exe。

### 0.1

项目初始化，加了简单的界面和一些动效。

