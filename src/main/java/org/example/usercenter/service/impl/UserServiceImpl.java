package org.example.usercenter.service.impl;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.usercenter.dto.UserHolder;
import org.example.usercenter.mapper.UserMapper;
import org.example.usercenter.pojo.LoginFormDTO;
import org.example.usercenter.pojo.Result;
import org.example.usercenter.service.IUserService;
import org.example.usercenter.pojo.User;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.RandomUtil;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.example.usercenter.utils.RedisConstants.*;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private  UserMapper userMapper;
    // 发送验证码
    @Override
    public Result sendCode(String phone) {
        String code = "123123"; // 固定验证码方便测试
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, 5, TimeUnit.MINUTES);
        return Result.ok("123123");
    }

    @Override
    public Result queryUserByPhone(String phone) {
        User user = userMapper.gerUserByPhone(phone);
        if (user == null) {
            return Result.fail("该用户不存在");
        }
        return Result.ok(user);
    }

    @Override
    public Result getSelfInfo() {
        User user = UserHolder.getUser();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId().toString());
        userMap.put("nickname", user.getNickname());
        userMap.put("phone", user.getPhone());
        // 获取coins数量和从大到小的排名
        Integer coins = stringRedisTemplate.opsForZSet().score(LOGIN_COIN_KEY, user.getId().toString()).intValue();
        Integer rank = 0; // 默认排名为0（第一名）
        Integer tempRank = stringRedisTemplate.opsForZSet().reverseRank(LOGIN_COIN_KEY, user.getId().toString()).intValue();
        if (tempRank != null) {
            rank = tempRank;
        }
        userMap.put("coins", coins);
        userMap.put("rank", rank);
        return Result.ok(userMap);
    }

    // 登录/注册
    @Override
    public Result login(LoginFormDTO loginForm) {
        String phone = loginForm.getPhone();
        String code = loginForm.getCode();

        // 验证码校验
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
        if (!code.equals(cacheCode)) {
            return Result.fail("验证码错误");
        }

        // 查询或创建用户
        User user = query().eq("phone", phone).one();
        if (user == null) {
            user = new User();
            user.setPhone(phone);
            user.setNickname("用户_" + RandomUtil.randomString(6));
            UserHolder.saveUser(user);
            save(user);

            //首次注册，送100coin，存在zset
            stringRedisTemplate.opsForZSet().add(LOGIN_COIN_KEY, user.getId().toString(), 100L);
        }

        // 生成token并存储用户信息
        String token = UUID.randomUUID().toString();
        System.out.println("token: " + token);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId().toString());
        userMap.put("nickname", user.getNickname());
        userMap.put("phone", user.getPhone());

        stringRedisTemplate.opsForHash().putAll(LOGIN_USER_KEY + token, userMap);
        stringRedisTemplate.expire(LOGIN_USER_KEY + token, 30, TimeUnit.MINUTES);

        // 获取coins数量和从大到小的排名
        //转化为int
        Integer coins = 100; // 默认100coin
        Double score = stringRedisTemplate.opsForZSet().score(LOGIN_COIN_KEY, user.getId().toString());
        if (score != null) {
            coins = score.intValue();
        }

        Integer rank = 0; // 默认排名为0（第一名）
        Long tempRank = stringRedisTemplate.opsForZSet().reverseRank(LOGIN_COIN_KEY, user.getId().toString());
        if (tempRank != null) {
            rank = tempRank.intValue();
        }
        Map<String, Object> data = new HashMap<>();
        data.put("coins", coins);
        data.put("rank", rank+1);
        data.put("user", user);
        data.put("token", token);
        return Result.ok(data);
    }

    // 退出登录
    @Override
    public Result logout(String  token) {
        if (token != null) {
            stringRedisTemplate.delete(LOGIN_USER_KEY + token);
        }
        UserHolder.removeUser();
        return Result.ok();
    }

    @Override
    public Result changeSelfInfo(User user) {
        UserHolder.getUser().setNickname(user.getNickname());
        UserHolder.getUser().setPhone(user.getPhone());
        //利用mybatis更新数据库
        userMapper.updateById(UserHolder.getUser());

        return Result.ok();
    }
}
