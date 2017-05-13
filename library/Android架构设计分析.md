# Android架构设计分析

## 分析

为了快速搭建app和灵活地变动，应该构建公共组件和业务组件，即以android studio工程为准，分出两个module。

一个module为library（也可以有多个library module），由公共组件组成，这个module便于迁移，只要少量修改就能迁移到其他工程中使用；

一个module为app，由业务组件组成，以业务来进行分包，用包名为区别业务类型，这样也便于维护业务。

- **先以一个App例子来分析：**
	
	    -com.mcs.test
	        +业务一  //业务一
	        +业务二
	        +业务三
	        +业务四
	        -业务五
	            +model
	            -view
	                +adapter
	                +activity
	                +fragment
	                +widget
	            +presenter
	            +utils
	        +业务六
	        -AppConstants.java //App全局常量
	        -MyApplication.java //Application类



## 参考

[Android架构合集](https://github.com/Juude/Awesome-Android-Architecture#%E5%B8%B8%E8%A7%81%E6%9E%B6%E6%9E%84%E6%96%B9%E6%B3%95)

[安居客 Android 项目架构演进](https://zhuanlan.zhihu.com/p/25420181)

[MinimalistWeather](https://github.com/BaronZ88/MinimalistWeather)

[MvpArms](https://github.com/JessYanCoding/MVPArms/blob/master/MVPArms.md)

[Android Architecture](https://github.com/googlesamples/android-architecture)

[悦跑圈 Android 单业务开发，提高编译效率 15 倍](https://www.diycode.cc/topics/761)

[新闻客户端 A news-reading App (MVP+Dagger2+RxJava+Retrofit2+Material Design)](https://github.com/kaku2015/ColorfulNews)