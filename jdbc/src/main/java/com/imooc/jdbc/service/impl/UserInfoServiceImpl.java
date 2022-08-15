package com.imooc.jdbc.service.impl;

import com.imooc.jdbc.dao.UserInfoDao;
import com.imooc.jdbc.entity.UserInfo;
import com.imooc.jdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mock
 * @date: 2022/8/15 18:44
 * @Description: UserInfoServiceImpl
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao dao;

    @Override
    public UserInfo findUserInfo(String username) {
        return dao.findByUserName(username);
    }
}
