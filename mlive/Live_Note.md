# 直播开发学习

## 概述

直播主要分三大部分，采集端、服务器和播放端。即把主播录制的视频，推流到服务器，经过服务器处理（如鉴黄等），最后通过CDN（Content Delivery Network 内容分发网络）分发给观众看。

## 技术要点分析

### 基于Android直播技术分析


### 各个知识点简单使用

**1、Camera**

（1）使用Camera类采集摄像头数据

- 声明权限

	<uses-permission android:name="android.permission.CAMERA"/>

在Android6.0以上版本(即Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)，这个权限属于危险权限，需要运行时权限动态申请

Android标准接口申请：

如果在**onResume**中申请，申请失败时会出现循环申请的问题，建议在**onStart**中处理

		private void requestPermission() {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
				if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
		                == PackageManager.PERMISSION_GRANTED) {
		            //拥有权限
		            
		        } else {
		            //申请权限
		            ActivityCompat.requestPermissions
		                    (this, new String[] {Manifest.permission.CAMERA}, 1);
		        }
			}
	        
	    }
	
	    @Override
	    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
	        if (requestCode == 1) {
	            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
	                //获取权限成功
	                
	            } else {
	                //获取权限失败
	                
	            }
	        }
	   }

使用RxPermissions库进行申请：

	RxPermissions rxPermissions = new RxPermissions(this);
	rxPermissions
	        .request(Manifest.permission.CAMERA)
	        .subscribe(new Action1<Boolean>() {
	            @Override
	            public void call(Boolean aBoolean) {
	                if (aBoolean) {//成功获取
	                   
	                } else {//获取失败
	                    
	                }
	            }
	        });

### Camera参考

[Android相机实时自动对焦的完美实现](http://blog.csdn.net/huweigoodboy/article/details/51378751)

[SweetCamera](https://github.com/huweigoodboy/SweetCamera)


## 参考

[直播技术的总结](https://github.com/tiantianlan/LiveExplanation)

[如何搭建一个完整的视频直播系统？](https://www.zhihu.com/question/42162310)

[Android中直播视频技术探究之—基础知识大纲介绍](http://befo.io/1545.html)

[Android中直播视频技术探究之---摄像头Camera视频源数据采集解析](http://blog.csdn.net/jiangwei0910410003/article/details/52057543)

[Android中直播视频技术探究之---视频直播服务端环境搭建(Nginx+RTMP)](http://blog.csdn.net/jiangwei0910410003/article/details/51996940)

[Android中直播视频技术探究之---基础核心类ByteBuffer解析](http://blog.csdn.net/jiangwei0910410003/article/details/51894596)

[Android中直播视频技术探究之---采集摄像头Camera视频源数据进行推流(采用金山云SDK)](http://blog.csdn.net/jiangwei0910410003/article/details/52068290)

[Android中直播视频技术探究之---桌面屏幕视频数据源采集功能分析](http://blog.csdn.net/jiangwei0910410003/article/details/52134342)

[直播类 APP 项目开发实战（原理篇）](http://ios.jobbole.com/92323/)

[优酷来疯直播开源项目](https://github.com/LaiFeng-Android/SopCastComponent)

[做一款仿映客的直播App？看我就够了](http://www.jianshu.com/p/5b1341e97757)