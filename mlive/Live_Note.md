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

[google CameraView](https://github.com/google/cameraview)

[Android相机实时自动对焦的完美实现](http://blog.csdn.net/huweigoodboy/article/details/51378751)

[SweetCamera](https://github.com/huweigoodboy/SweetCamera)

[仿微信拍照Android控件](https://github.com/CJT2325/CameraView)


**2、推流**

**2.1 利用金山云SDK来进行推流**

（1）从[sdk](https://github.com/ksvc/KSYStreamer_Android)下载源码，进行编译

编译过程注意，如果修改demo下的build.gradle,修改mavenCentral()为jcenter()，避免gradle依赖reuse connect

如果gradle/gradle-wrapper.properties下的distributionUrl对应的gradle包下载失败，可以修改为已下载好的gradle包。


（2）配置nginx服务器，用于处理中转

需要在linux环境下配置服务器，现基于ubuntu环境下进行配置：

- 下载nginx服务器源代码，下载地址为[nginx源码-1.11.13](http://nginx.org/download/nginx-1.11.13.tar.gz)

- 安装依赖库，openssl、pcre

		sudo apt-get install openssl libssl-dev  
		
		sudo apt-get install libpcre3 libpcre3-dev  

- 下载nginx rtmp module

		git clone https://github.com/arut/nginx-rtmp-module.git

- 编译源码、安装nginx

		./configure --prefix=/usr/local/nginx --add-module=/home/mochangsheng/live/nginx-rtmp-module --with-http_ssl_module --with-debug
		
		make
		
		sudo make install 

- 配置nginx

	修改/usr/local/nginx/conf/nginx.conf，添加rtmp配置项
	
		rtmp {   #rtmp服务
		   server {
		       listen 1935; #服务端口号
		       chunk_size 4096;  #数据传输块的大小
		       application myapp {
		           live on;
		       }
		       application hls {
		           live on;
		           hls on;
		           hls_path /tmp/hls;
		       }
		   }
		}
	
	切换到/usr/local/nginx/sbin，执行sudo ./nginx -c ../conf/nginx.conf， 使配置生效

	启动nginx，  sudo ./nginx

- 在浏览器输入localhost，看是否能成功进入nginx的欢迎页面

- 安装ffmpeg工具，来进行测试

		sudo apt-get install ffmpeg

- 推流测试
	
		//注意myapp指定要与nginx.conf中的application一致
		ffmpeg -re -i test.flv -f flv rtmp://10.0.2.15/myapp/test1

- 拉流测试

		ffplay rtmp://10.0.2.15/myapp/test1

#### 注意 

- virtualbox虚拟机共享文件夹，需要执行的命令 sudo mount -t vboxsf myGithub /mnt/shared/

- 若需要测试手机推流，可以先测试virtualbox为网络桥接模式，配置手机和服务器在同一网段上，就可以了

### 参考 

[搭建nginx rtmp直播服务器，ffmpeg模拟推流](http://cxuef.github.io/linux/%E3%80%90%E7%BD%AE%E9%A1%B6%E3%80%91%E6%90%AD%E5%BB%BAnginx-rtmp%E7%9B%B4%E6%92%AD%E6%9C%8D%E5%8A%A1%E5%99%A8%EF%BC%8Cffmpeg%E6%A8%A1%E6%8B%9F%E6%8E%A8%E6%B5%81/)

[ubuntu下安装nginx时依赖库zlib，pcre，openssl安装方法](http://blog.csdn.net/z920954494/article/details/52132125)

[利用nginx搭建RTMP视频点播、直播、HLS服务器](http://lib.csdn.net/article/57/37915?knId=1549)

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