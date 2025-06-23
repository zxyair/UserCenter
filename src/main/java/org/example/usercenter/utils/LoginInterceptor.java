package org.example.usercenter.utils;

import org.example.usercenter.dto.UserHolder;
import org.example.usercenter.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static org.example.usercenter.utils.RedisConstants.LOGIN_USER_KEY;
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.从请求头获取token
        if (request == null) {
            response.setStatus(500);
            response.getWriter().write("{\"code\":\"500\", \"msg\":\"内部服务器错误\"}");
            return false;
        }

        // 2.从请求头获取token
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return unauthorizedResponse(response, "未提供token");
        }
        // 2.从Redis中获取用户信息
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(LOGIN_USER_KEY + token);
        if (userMap.isEmpty()) {
            return unauthorizedResponse(response, "token无效或已过期");
        }

        // 3.将用户信息存入ThreadLocal
        User user = new User();
        try {
            String id = (String) userMap.get("id");
            String nickname = (String) userMap.get("nickname");
            String phone = (String) userMap.get("phone");

            if (id == null || nickname == null || phone == null) {
                return unauthorizedResponse(response, "用户信息不完整");
            }

            user.setId(Long.valueOf(id));
            user.setNickname(nickname);
            user.setPhone(phone);
            UserHolder.saveUser(user);
        } catch (Exception e) {
            return unauthorizedResponse(response, "用户信息解析失败");
        }

        return true;
    }

    private boolean unauthorizedResponse(HttpServletResponse response, String message) throws Exception {
        response.setStatus(401);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("{\"code\":\"401\", \"msg\":\"" + message + "\"}");
        return false;
    }
}
