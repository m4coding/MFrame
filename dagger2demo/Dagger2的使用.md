## 简述

依赖注解库(Dependency Inject简称DI)，基于编译时注解的，现在由google公司维护。

依赖注入：就是目标类中所依赖的其他的类的初始化过程，不是通过手动编码的方式创建，而是通过技术手段可以把其他的类的已经初始化好的实例自动注入到目标类中。

**注解（Annotation**，也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。

Dagger2框架基本部分有四大部分，**Inject**、**Component**、**Module**和**Provides**。

- Inject主要是用来标注目标类的依赖和依赖的构造函数

- Component是一个桥梁，一端是目标类，另一端是目标类所依赖类的实例，即是注入器负责把目标类所依赖类的实例注入到目标类中，同时它也管理着Module

- Module和Provides是为解决第三方类库的（因为第三方类库如果不能修改，是添加不了Inject注解的，这时需要Module），Module是一个简单工厂模式，包含创建类实例（第三方类库的类）的方法，这些方法用Provides来标注

```java
@Module
public class ModuleClass{
      //A是第三方类库中的一个类
	  @Provides
      A provideA(){
           return A();
      }
}
```

其他概念分析，**Qualifier**（限定符）、**Singleton**（单例）、**Scope**（作用域）

- Qualifier主要用来解决依赖迷失的。例如

```java
//依赖类
@Inject 
A() {}

@Inject 
A(...){}

//目标类
@Inject 
A a;
```

若一个类的实例有很多种方法可以创建出来，那么注入器Component应该哪个方法？

上面这种情况，Component是无法识别的，需要通过Qualifier来进行限制标注才行

- Singleton，用于注解单例

- Scope，注解作用域，解决Component的依赖、包含和继承。

## 优点

- 增加开发效率、省去重复的简单体力劳动
- 更好的管理类实例
- 解耦

## 使用


## 参考

[Dagger2 Github地址](https://github.com/google/dagger)

[Android：dagger2让你爱不释手-基础依赖注入框架篇](http://www.jianshu.com/p/cd2c1c9f68d4)

[Android：dagger2让你爱不释手-重点概念讲解、融合篇](http://www.jianshu.com/p/1d42d2e6f4a5)

[Android：dagger2让你爱不释手-终结篇](http://www.jianshu.com/p/65737ac39c44)

[清晰 dagger2 中译文教程系列](https://juejin.im/entry/572232fc1532bc00624b5c8e)


[dagger 2 详解](http://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650820566&idx=1&sn=3575d671c7e071541a846f9074c0090a&scene=4#wechat_redirect)