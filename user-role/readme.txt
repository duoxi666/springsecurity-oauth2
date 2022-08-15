ch07-user-role: 使用用户和角色,认证用户


实现步骤:
    1.新建maven项目
    2.加入maven坐标
        1)spring-boot:2.0.6
        2)spring-security
        3)spring-web
        4)spring和mybatis相关的依赖
        5)mysql驱动

    3.编写application.properties
        连接数据库,创建连接池

    4.创建自己的user类,代替UserDetails

    5.创建自定义的UserDetailService实现类
        在重写方法中,查询数据库获取用户信息,获取角色数据。
        构建UserDetails实现对象。

    6.创建配置类继承WebSecurityConfigurerAdapter
        自定义安全的配置

    7.自定义登录
        1) 传统form登录
        2) ajax登录

    8.创建测试Controller


自定义登录页面和验证码的使用
    1.完善自定义登录页面。
    2.实现验证码的功能(生成验证码;检查提交的验证码)
    3.完善自定义登录页面
    4. 创建自定义登录页面
        登录页面 resource/static/mylogin.html
        action: /login 可以自定义
        method: post这个是一定的。
        参数: username, password  可以自定义,修改spring security配置

        错误提示页面 resource/static/error.html
            error.html 登录错误,请检查用户名和密码


        2.设置自定义登录的参数,重写config方法
            (1)设置访问的白名单,无需登录验证就可以访问的地址
            (2)指定登录页面,登录的uri地址
            (3)指定登录错误的提示页面

        3.关闭跨域访问的安全设置。

    上面的登录方式是基于表单form的。对于现在的前后端分离的方式不适合。
    如果要使用前后端分离,一般使用json作为数据的交换格式。需要使用另外一种方式才可以。