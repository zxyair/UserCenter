package org.example.usercenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.usercenter.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

/**
 * 根据手机号查询用户
 * @param phone 手机号
 * @return 用户信息
 */
    @Select("SELECT * FROM user WHERE phone = #{phone}")
    User gerUserByPhone(String phone);




}
