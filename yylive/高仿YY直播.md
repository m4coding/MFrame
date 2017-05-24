# 高仿YY直播 基于v6.15版本

## 利用Fiddler进行抓包

获取首页标题

	http://idx.3g.yy.com/mobyy/navs?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

	//url
	http://idx.3g.yy.com/mobyy/navs

获取列表图片

	http://emyfs.bs2cdn.yy.com/N2NjZGUwNzctOTMwYS00ZmRjLWI2MzQtMGZjMTU4YmNlZTFi.jpg?imageview/4/0/w/363/h/330/blur/1

热门导航栏

	简化：
	http://idx.3g.yy.com/mobyy/nav/index/idx?os=android&yyVersion=6.1.5

	http://idx.3g.yy.com/mobyy/nav/index/idx?os=android&netType=2&hdid=ffd13274c5796e636fd141cf1aa6ee53&channel=official&bkt=0&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=0&osVersion=6.0.1&imei=355066066195415&model=SM-G9008V&sdkVersion=6.1.5&ispType=4

歌舞导航栏

	http://data.3g.yy.com/mobyy/nav/sing/idx?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&bkt=0&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

脱口秀栏 

	//分三个栏目 专题-预告-现在直播
	http://data.3g.yy.com/mobyy/nav/talk/idx?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&bkt=0&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

	//第二次拉取现在直播数据
	http://data.3g.yy.com/mobyy/module/talk/idx/331?page=5&os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&bkt=0&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1


附近下标题栏

	//排列是按距离来排的
	http://data.3g.yy.com/social/mobyy/near/idx?os=android&lng=113.382572&city=%E5%B9%BF%E5%B7%9E%E5%B8%82&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&cty=%E4%B8%AD%E5%9B%BD&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&prv=%E5%B9%BF%E4%B8%9C%E7%9C%81&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&page=1&ispType=1&lat=23.126755

社区下标题栏

	//社区
	http://data.3g.yy.com/discover/v2/info?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

意见反馈

	http://res.3g.yy.com/feedback/m/android/feedback.json

联系我们html

	http://act.yy.com/act/alpha/contact.html

3、 待定api

	http://res.3g.yy.com/config/m/android/share2.json

	http://data.3g.yy.com/switch/info?typeKey=channelchat&os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=0&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

	http://res.3g.yy.com/game/m/android/game.json	

	http://res.3g.yystatic.com/config/m/android/decodeSwitchV2.json

	http://res.3g.yy.com/config/m/android/heapPreference.json

	http://res.3g.yystatic.com/config/m/android/mediaconfig.json?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=0&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

	http://res.3g.yystatic.com/config/m/android/mediaconfig.json?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=0&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1

	http://res.3g.yystatic.com/config/m/android/netPromptMode.json

	http://res.3g.yy.com/config/m/android/area.json?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&mac=02%3A00%3A00%3A00%3A00%3A00&uid=1737889437&osVersion=6.0.1&imei=460026188898485&model=MI+5&sdkVersion=6.1.5&ispType=1



4、 异常上报

	POST http://crash-reporting.yy.com/dau/reporting HTTP/1.1
	Content-Type: multipart/form-data; boundary=7a76c781-0f82-4dc6-8168-6c970d8ca7cc
	Content-Length: 585
	Host: crash-reporting.yy.com
	Connection: Keep-Alive
	Accept-Encoding: gzip
	User-Agent: okhttp/3.0.1
	
	--7a76c781-0f82-4dc6-8168-6c970d8ca7cc
	Content-Disposition: form-data; name="appId"
	Content-Length: 6
	
	yymand
	--7a76c781-0f82-4dc6-8168-6c970d8ca7cc
	Content-Disposition: form-data; name="data"
	Content-Length: 210
	
	{"ver":"6.1.5","imei":"99000877128285","pkg_name":"com.duowan.mobile","from":"1505","guid":"a6a2ff49-564b-4fea-af7d-b60c1902c4b7","key":"178197958f3510cfa0c0b0fb8b3f3835","mac":"02:00:00:00:00:00","net":"WIFI"}
	--7a76c781-0f82-4dc6-8168-6c970d8ca7cc
	Content-Disposition: form-data; name="sign"
	Content-Length: 0
	
	
	--7a76c781-0f82-4dc6-8168-6c970d8ca7cc--


http://idx.3g.yy.com/mobyy/navs?os=android&netType=2&hdid=44bca58e2005403ac0230af554a54e25&channel=1505&yyVersion=6.1.5&uid=1737889437&osVersion=6.0.1&sdkVersion=6.1.5&ispType=1

http://idx.3g.yy.com/mobyy/navs?os=android&netType=2&channel=1505&yyVersion=6.1.5&uid=1737889437&sdkVersion=6.1.5


## 使用到的第三方库

下拉刷新

	https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh

mvp参考

	https://github.com/googlesamples/android-architecture

	https://github.com/JessYanCoding/MVPArms