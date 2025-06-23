package org.example.usercenter.service.impl;
import org.example.usercenter.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.example.usercenter.pojo.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.usercenter.service.IUserInfoService;
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserMapper, User> implements IUserInfoService {

}
