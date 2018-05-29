package com.tripin.application.mapper;

import com.tripin.application.entity.*;
import com.tripin.application.enums.*;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * Title: UserBaseMapper
 * Description: 数据库表资源映射 用户基本信息
 *
 * @Author: Felix
 * @Date: 2018/5/29 18:54
 * @Version: 1.0
 **/

@Mapper
public interface UserBaseMapper {

    @Select("SELECT * FROM UserBase")
    List<UserBase> getAll();

}
