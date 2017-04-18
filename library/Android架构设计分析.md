# Android架构设计分析

## 分析

为了快速搭建app和灵活地变动，应该构建公共组件和业务组件，即以android studio工程为准，分出两个module。

一个module为library（也可以有多个library module），由公共组件组成，这个module便于迁移，只要少量修改就能迁移到其他工程中使用；

一个module为app，由业务组件组成，以业务来进行分包，用包名为区别业务类型，这样也便于维护业务。

- **先以一个例子来分析：**



## 参考

[Android架构合集](https://github.com/Juude/Awesome-Android-Architecture#%E5%B8%B8%E8%A7%81%E6%9E%B6%E6%9E%84%E6%96%B9%E6%B3%95)

[安居客 Android 项目架构演进](https://zhuanlan.zhihu.com/p/25420181)

[MinimalistWeather](https://github.com/BaronZ88/MinimalistWeather)