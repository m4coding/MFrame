## 简述

依赖注解库，基于编译时注解的，现在有google公司维护。

依赖注入：就是目标类中所依赖的其他的类的初始化过程，不是通过手动编码的方式创建，而是通过技术手段可以把其他的类的已经初始化好的实例自动注入到目标类中。

**注解（Annotation**，也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。

Dagger2框架主要有四大部分，**Inject**、**Component**、**Module**和**Provides**。

- Inject主要是用来标注目标类的依赖和依赖的构造函数

- Component是一个桥梁，一端是目标类，另一端是目标类所依赖类的实例，即是注入器负责把目标类所依赖类的实例注入到目标类中，同时它也管理着Module

- Module和Provides是为解决第三方类库的（因为第三方类库如果不能修改，是添加不了Inject注解的，这时需要Module），Module是一个简单工厂模式，包含创建类实例（第三方类库的类）的方法，这些方法用Provides来标注

    @Module
    public class ModuleClass{
          //A是第三方类库中的一个类
    	  @Provides
          A provideA(){
               return A();
          }
    }


## 使用


## 参考

[Android：dagger2让你爱不释手-基础依赖注入框架篇](http://www.jianshu.com/p/cd2c1c9f68d4)