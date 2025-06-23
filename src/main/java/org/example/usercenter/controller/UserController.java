package org.example.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.usercenter.dto.UserHolder;
import org.example.usercenter.pojo.LoginFormDTO;
import org.example.usercenter.pojo.Result;
import org.example.usercenter.pojo.User;
import org.example.usercenter.service.IUserInfoService;
import org.example.usercenter.service.IUserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IUserInfoService userInfoService;

    /**
     * 发送手机验证码
     */
    @PostMapping("code")
    public Result sendCode(@RequestParam("phone") String phone) {
        // 发送短信验证码并保存验证码
        return userService.sendCode(phone);
    }

    /**
     * 登录功能
     * @param loginForm 登录参数，包含手机号、验证码；或者手机号、密码
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginForm){
        // 实现登录功能
        return userService.login(loginForm);
    }

    /**
     * 登出功能
     * @return 无
     */
    @PostMapping("/logout")
    public Result logout(@RequestParam("token") String token){
//        String token = request.getHeader("authorization");
        System.out.println(token);
        return userService.logout(token);

    }

    @GetMapping("/me")
    public Result me(){
        return userService.getSelfInfo();
    }

    /**
     * 修改个人信息
     * @param user
     * @return 修改结果
     */
    @PostMapping("/user/changeSelfInfo")
    public Result changeSelfInfo(@RequestBody User user){
        return userService.changeSelfInfo(user);
    }


    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long userId) {
        // 查询详情
        User info = userInfoService.getById(userId);
        if (info == null) {
            // 没有详情，应该是第一次查看详情
            return Result.ok("没有该用户");
        }
        info.setCreateTime(null);
        info.setUpdateTime(null);
        // 返回
        return Result.ok(info);
    }


    @GetMapping("/{Phone}")
    public Result queryUserByPhone(@RequestParam("Phone") String Phone){
        // 查询详情
        return userService.queryUserByPhone(Phone);
    }


}