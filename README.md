Open WorkShop - Go
==================


WorkShop
--------

欢迎大家来参加这次Open Workshop，你需要作以下准备

  - 有一个GitHub账号
  - 笔记本
    - 操作系统不限，安装有Git，JDK 7
    - 从`https://services.gradle.org/distributions/gradle-2.0-bin.zip`下载gradle-2.0-bin.zip到用户根目录，供Gradle Wrapper使用
    - 从`http://www.go.cd/download/`下载对应平台的Go安装程序
  - 也可以下载封装好的Docker image，用Docker搭建Go的C/S架构
    - lxdcn/openworkshop-go-server
    - lxdcn/openworkshop-go-agent




关于这个工程
-----------

这个是一个基于Spring，Gradle打包的Java项目，我剥离了MySQL部分，作为这次Open Workshop的项目样本。

这个项目有两个模块core和web，core放有所有的domain对象，web是一个war，依赖于core；各自都有单元测试和集成测试。

工程在容器里启动之后可以用浏览器访问http://localhost:8080/web/index.html。




Acknowledgement
---------------

https://github.com/weixiaobo88/userManagement

