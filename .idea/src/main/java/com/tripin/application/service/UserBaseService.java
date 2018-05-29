package com.tripin.application.service;

import com.tripin.application.mapper.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title: UserBaseService
 * Description: 业务处理 用户基本
 *
 * @Author: Felix
 * @Date: 2018/5/29 18:54
 * @Version: 1.0
 **/

@Service
public class UserBaseService {

    @Autowired
    private UserBaseMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger("com.service.UserService");

    @Transactional
    public String getUserMessage(){
        logger.info("in getUserMessage.");
        return userMapper.getAll().toString();
    }

}