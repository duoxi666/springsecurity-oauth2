package com.imooc.jdbc.init;

/**
 * @author: Mock
 * @date: 2022/8/15 18:39
 * @Description: init db
 * @Sign 一入码门深似海 头秃自然千金来
 */

import com.imooc.jdbc.dao.UserInfoDao;
import com.imooc.jdbc.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 第二次注销掉这两个注解，防止启动时重新添加记录
 */
// @Component
public class JdbcInit {

    @Autowired
    private UserInfoDao userInfoDao;

    //像数据库中初始化插入数据,在IOC容器加载的时候就执行这个方法
    // @PostConstruct
    public void init() {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        UserInfo u = new UserInfo();
        u.setUserName("zhangsan");
        u.setPassWord(passwordEncoder.encode("123456"));
        u.setRole("user");

        userInfoDao.save(u);

        u = new UserInfo();
        u.setUserName("admin");
        u.setPassWord(passwordEncoder.encode("admin"));
        u.setRole("admin");

        userInfoDao.save(u);
    }
}
