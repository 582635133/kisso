
-----------------------------------------------------------------
kisso 启动  web.xml 配置
、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、

<!-- SSO 配置 -->
<context-param>
	<param-name>kissoConfigLocation</param-name>
	<param-value>classpath:properties/sso.properties</param-value>
</context-param>
<listener>
	<listener-class>com.baomidou.kisso.web.KissoConfigListener</listener-class>
</listener>


-----------------------------------------------------------------
spring SSO 拦截器配置
、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、

<mvc:interceptors>
	<!-- SSO 拦截器 -->
	<!-- path 对所有的请求拦截使用/**，对某个模块下的请求拦截使用：/myPath/* -->
	<mvc:interceptor>
		<mvc:mapping path="/**" />
		<bean class="com.baomidou.kisso.web.spring.SSOInterceptor" />
	</mvc:interceptor>
</mvc:interceptors>


-----------------------------------------------------------------
spring SSO 拦截器配置，此基础上支持方法注解，如下跳过该方法登录验证。
、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、

@Login(action = Action.Skip)


-------------------------------------------------------------------
sso.properties 配置说明
、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、

sso.production.mode  模式配置，默认不带后缀为线上模式，
					   模式设置：_dev_mode 开发 ，_test_mode 测试 ，_online_mode 生产

sso.encoding		   编码格式： 默认 UTF-8

sso.secretkey		  加密密钥

------  cookie 设置部分 ------
sso.cookie.name			名称，默认 uid

sso.cookie.secure		是否只能HTTPS访问，默认 false 				【客户端配置可无】
sso.cookie.httponly 	是否设置 httponly脚本无法访问，默认 true   	【客户端配置可无】
sso.cookie.maxage		过期时间，默认 -1 关闭浏览器失效 				【客户端配置可无】
sso.cookie.domain		所在域，请设置根域，如 .baomidou.com 		【客户端配置可无】
sso.cookie.path			路径，默认 / 							【客户端配置可无】

sso.cookie.browser		是否检查浏览器，默认 true
sso.cookie.checkip		是否检查登录IP，默认 false
sso.encrypt.class		自定义对称加密类，默认AES，自定义例如：com.testdemo.DES
sso.token.class			自定义票据，默认SSOTokwn，自定义例如：com.testdemo.LoginToken

------  Token 缓存部分 ------
sso.tokencache.class	自定义缓存实现：com.testdemo.RedisCache
sso.tokencache.expires  单位s秒，设置 -1永不失效，大于 0 失效时间

------  SSO 请求地址设置 ------
sso.login.url_online_mode		线上模式，登录地址：http://sso.testdemo.com/login.html
sso.login.url_dev_mode			开发模式，登录地址：http://localhost:8080/login.html

sso.logout.url_online_mode		线上模式，退出地址：http://sso.testdemo.com/logout.html
sso.logout.url_dev_mode			开发模式，退出地址：http://localhost:8080/logout.html

sso.param.returl				重定向地址参数配置，默认：ReturnURL

------  跨域 cookie 设置部分 ------
sso.crossdomain.cookie.name		名称pid，请不要与登录 cookie 名称一致
sso.crossdomain.cookie.maxage	过期时间，默认 -1 关闭浏览器失效

-----------------------------------------------------------------



