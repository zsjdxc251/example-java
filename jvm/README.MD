### jvm 参数

#### 1. 标准参数

**不会随着JDK版本改变而改变的**

```shell
-version
-help
-server
-cp
```



#### 2. -X 参数

**非标准参数，也就是JDK各个版本中可能会变动**

```shell
java -xint -version  #解析器执行
java -xcomp -version #第一次使用就编译成本地代码
java -Xmixed -version  # 混合模式，Jvm 自己来决定

```



####  3. -XX参数

**使用最多的参数类型，非标准化参数，相对不稳定，主要用于Jvm调优和Debug**

* `Boolean`类型

  * 格式: `-xx:[+-]<name>` +或-表示启用或者禁用name属性

  * 比如: `-XX:+UseConcMarkSweepGc`    表示启用 GMS类型的垃圾回收器

    `-XX:+UseG1Gc` 表示启用G1 类型的垃圾回收器

* 非`Boolean`类型

  * 格式: `-XX:<name>=<value>` 表示name属性值是`value`
  * 比如: `-XX:MaxGCPauseMillis=500`

#### 4. 其他参数

**相当于是-XX类型参数的缩写**

```shell
-Xms1000 等价于 -XX:InitialHeapSize=1000
-Xms1000 等价于 -XX:MaxHeapSize=1000
-Xss100  等价于 -XX:ThreadStackSize=100
```





