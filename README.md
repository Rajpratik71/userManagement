Open WorkShop - Go
==================

<br />

WorkShop
--------

欢迎大家来参加这次Open Workshop，你需要作以下准备

  - 有一个GitHub账号
  - 环境搭建，你可以采用以下两种方式：
    1. 笔记本操作系统不限，安装有Git，JDK 7，以及：
      - 从`https://services.gradle.org/distributions/gradle-2.0-bin.zip`下载gradle-2.0-bin.zip到**用户根目录**，供Gradle Wrapper使用
      - 从`http://www.go.cd/download/`下载对应平台的Go Server安装程序和Go Agent安装程序
    2. 也可以用Docker搭建Go的C/S架构，封装好的image如下：
      - `lxdcn/openworkshop-go-server`
      - `lxdcn/openworkshop-go-agent`


<br /><br />

关于这个工程
-----------

这个是一个基于Spring，Gradle打包的Java项目，我剥离了MySQL部分，作为这次Open Workshop的项目样本。

这个项目有两个模块`core`和`web`，`core`放有所有的domain对象，`web`是一个war，依赖于`core`；各自都有单元测试和集成测试。

工程在容器里启动之后可以用浏览器访问`http://localhost:8080/web/index.html`。




<br /><br />

CI脚本解释
---------

core模块的编译：`sh script/core-compile.sh`

core模块的单元测试：`sh script/core-ut.sh`

core模块的集成测试：`sh script/core-integration-test.sh`

core模块打jar包：`sh script/core-package.sh`

<br />
web模块的编译：`sh script/web-compile.sh`

web模块的单元测试：`sh script/web-ut.sh`

web模块打war包：`sh script/web-package.sh`


<br /><br /><br />

core模块生成的jar包路径在`core/build/libs/core.jar`
web模块生成的jar包路径在`web/build/libs/web.war`

<br /><br />

Acknowledgement
---------------

https://github.com/weixiaobo88/userManagement

