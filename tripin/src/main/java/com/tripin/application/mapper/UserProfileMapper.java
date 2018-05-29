package com.tripin.application.mapper;

import com.tripin.application.entity.UserProfile;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Title: UserBaseMapper
 * Description: 数据库表资源映射 用户基本信息
 *
 * @Author: Felix
 * @Date: 2018/5/29 20:49
 * @Version: 1.0
 **/

public interface UserProfileMapper {


    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getAll();
}
