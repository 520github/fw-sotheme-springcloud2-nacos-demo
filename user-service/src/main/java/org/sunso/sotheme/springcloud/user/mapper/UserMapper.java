package org.sunso.sotheme.springcloud.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sunso.sotheme.springcloud.common.base.CommonMapper;
import org.sunso.sotheme.springcloud.user.entity.User;

public interface UserMapper extends CommonMapper<User> {

    @Select("select * from user where id=#{userId}")
    User getOneByUserId(@Param("userId") Long userId);

    User findOneByUserId(@Param("userId") Long userId);
}
