## https://github.com/dangdangdotcom/config-toolkit

### 下载源码并编译运行
```git clone https://github.com/dangdangdotcom/config-toolkit.git```
```cd config-toolkit/config-face```
```mvn package```
```java -jar config-face.jar --zk=localhost:2181```


### 创建初始权限配置

使用命令行创建zookeeper配置根节点，根节点密码使用sha1加密，如果要使用明文密码，可以自行修改config-zk-web的鉴权部分代码 以根路径为/projectx/modulex密码为abc为例

python -c "import hashlib;print hashlib.sha1('abc').hexdigest();"
# a9993e364706816aba3e25717850c26c9cd0d89d
zkCli.sh -server localhost:2181
create /projectx 1
create /projectx/modulex a9993e364706816aba3e25717850c26c9cd0d89d


登录config-web，创建示例配置

    访问http://localhost:8080/
    点击"切换根节点"，输入/projectx/modulex，密码abc
    点击"新建版本"，输入1.0.0
    左侧的组管理，输入group，点击"创建"
    在右侧添加两个配置，分别为config.str=hello, config.int=7758

