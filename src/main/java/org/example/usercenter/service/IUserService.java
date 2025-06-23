package org.example.usercenter.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.usercenter.pojo.LoginFormDTO;
import org.example.usercenter.pojo.Result;
import org.example.usercenter.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public interface IUserService extends IService<User> {

    Result sendCode(String phone);

    Result login(LoginFormDTO loginForm);

    Result logout(String token);

    Result getSelfInfo();

    Result queryUserByPhone(String phone);

    Result changeSelfInfo(User user);
}
