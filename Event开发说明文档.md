# Event开发说明文档

##开发模式：前后端分离

###前端：
	开发工具：微信开发者工具、WebStorm
    开发框架：mpvue
	npm版本：6.14.6
	UI：Vant UI

###后端：
	开发工具：IDEA
	JDK版本：1.8
	Spring Boot版本：2.3.0.RELEASE
	Maven安装与配置（参照CSDN或简书）
	数据源：Druid(Alibaba)
	
###数据库：
	MySQL
		host: 47.108.164.124
		port: 3306
		username: root
		password: ABCabc123
		
###服务器：
    阿里云

##详情：

###一.前端
	1. 安装node.js
		https://blog.csdn.net/qq_43285335/article/details/90696126
		
	2. 安装vue脚手架
		https://www.jianshu.com/p/f1a34631cf0d
		
	3. 如何运行github上的mpvue小程序开源项目
		https://blog.csdn.net/weixin_42149538/article/details/105990615?utm_medium=distribute.pc_relevant.none-task-blog-title-2&spm=1001.2101.3001.4242
	
	4. 微信小程序
		https://blog.csdn.net/qq_36538012/article/details/79570115?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522160536291619725225040572%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=160536291619725225040572&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-5-79570115.pc_first_rank_v2_rank_v28p&utm_term=%E5%BE%AE%E4%BF%A1%E5%B0%8F%E7%A8%8B%E5%BA%8F%E5%BC%80%E5%8F%91&spm=1018.2118.3001.4449

###二.后端
    1. 安装jdk1.8
    
    2.1 安装maven
    	https://blog.csdn.net/weixin_43811057/article/details/108235117
    	
    2.2 IDEA配置maven
    	在setting中将maven地址改为自己本地的maven地址
    	
    2. 初始化spring boot项目 （了解）
    	https://blog.csdn.net/baidu_39298625/article/details/98102453

##Git
    Git地址：https://github.com/NE14HZ/EvnetsApp
    
    Git使用：拉取分支，注意别直接拉main分支！提交前需要先Fetch和Merge(两步都要进行)，并解决可能的冲突
-------
