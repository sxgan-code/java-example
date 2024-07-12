package cn.sxgan.base.auth.services.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.jwt.JWTUtil;
import cn.sxgan.base.auth.entity.UserSessionInfo;
import cn.sxgan.base.auth.services.IAuthService;
import cn.sxgan.common.cache.redis.RedisUtil;
import cn.sxgan.common.consts.RedisConst;
import cn.sxgan.common.entity.SysUser;
import cn.sxgan.common.entity.query.SysUserQuery;
import cn.sxgan.common.enums.ResponseStatus;
import cn.sxgan.common.exception.AuthorityException;
import cn.sxgan.common.mappers.SysUserMapper;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.PasswordEncoderUtils;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 认证服务实现
 * @Author: sxgan
 * @Date: 24/7/12 17:50
 * @Version: 1.0
 **/
@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {
    
    @Value("${token.key}")
    private String tokenKey;
    
    @Resource
    RedisUtil redisUtil;
    
    @Resource
    SysUserMapper userMapper;
    
    @Override
    public ResponseResult<Map<String, String>> userAuthByEmail(UserSessionInfo userSessionInfo) {
        HashMap<String, String> map = Maps.newHashMap();
        SysUserQuery userQuery = new SysUserQuery();
        userQuery.setEmail(userSessionInfo.getEmail());
        List<SysUser> userList = userMapper.selectUserByCondition(userQuery);
        if (userList.size() > 0) {
            SysUser user = userList.get(0);
            // 判断密码是否正确,加密密码与库中（user对象）的password比对是否相同
            if (PasswordEncoderUtils.matches(user.getPassword(), userSessionInfo.getPassword())) {
                // 允许登陆，生成令牌
                // 写入用户信息
                HashMap<String, Object> tokenMap = new HashMap<>();
                tokenMap.put("email", user.getEmail());
                tokenMap.put("id", user.getUserId());
                String token = JWTUtil.createToken(tokenMap, tokenKey.getBytes());
                userSessionInfo.setId(user.getUserId());
                userSessionInfo.setUserName(user.getUserName());
                redisUtil.set(RedisConst.LOGIN_TOKEN_PREFIX + token, userSessionInfo, RedisConst.LOGIN_TIME_1,
                        TimeUnit.DAYS);
                map.put("token", token);
                return ResponseResult.success(map, 0);
            } else {
                return ResponseResult.fail(Maps.newHashMap(), ResponseStatus.EXCEPTION_STATUS_703.getCode(),
                        ResponseStatus.EXCEPTION_STATUS_703.getMsg());
            }
        } else {
            return ResponseResult.fail(Maps.newHashMap(), ResponseStatus.EXCEPTION_STATUS_701.getCode(),
                    ResponseStatus.EXCEPTION_STATUS_701.getMsg());
        }
    }
    
    @Override
    public ResponseResult<Map<String, String>> signupUserByEmail(UserSessionInfo userSessionInfo) {
        String email = userSessionInfo.getEmail();
        String password = userSessionInfo.getPassword();
        String verifyCode = userSessionInfo.getVerifyCode();
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(verifyCode)) {
            return ResponseResult.fail(Maps.newHashMap(), ResponseStatus.EXCEPTION_STATUS_704.getCode(),
                    ResponseStatus.EXCEPTION_STATUS_704.getMsg());
        }
        
        // 查询当前邮箱的验证码并验证
        String captchaCacheVal = redisUtil.get(RedisConst.CARD_CAPTCHA_PREFIX + email, String.class);
        log.info("AuthServiceImpl.signupUserByEmail captchaCacheVal = {}", captchaCacheVal);
        
        
        String[] captchaCacheValArr = null;
        if (captchaCacheVal != null) {
            captchaCacheValArr = captchaCacheVal.split("_");
            if (!captchaCacheValArr[0].equals(verifyCode)) {
                return ResponseResult.fail(Maps.newHashMap(), ResponseStatus.EXCEPTION_STATUS_705.getCode(),
                        ResponseStatus.EXCEPTION_STATUS_705.getMsg());
            }
        } else {
            return ResponseResult.fail(Maps.newHashMap(), ResponseStatus.EXCEPTION_STATUS_705.getCode(),
                    ResponseStatus.EXCEPTION_STATUS_705.getMsg());
        }
        
        long sendTime = Long.parseLong(captchaCacheValArr[2]);
        long currentTime = System.currentTimeMillis();
        if (currentTime - sendTime > 60 * 5 * 1000) {
            // return "验证码已过期";
        }
        // 查询邮箱是否已经注册
        SysUserQuery userQuery = new SysUserQuery();
        userQuery.setEmail(email);
        List<SysUser> userList = userMapper.selectUserByCondition(userQuery);
        if (userList.size() > 0) {
            return ResponseResult.fail(Maps.newHashMap(), ResponseStatus.EXCEPTION_STATUS_706.getCode(),
                    ResponseStatus.EXCEPTION_STATUS_706.getMsg());
        }
        // 注册账号
        SysUser user = new SysUser();
        user.setUserName(RandomUtil.randomString(12).toUpperCase(Locale.ROOT));
        user.setEmail(email);
        // 加密
        
        // 生成盐
        String salt = RandomUtil.randomString(20);
        String slatPass = PasswordEncoderUtils.encode(userSessionInfo.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(slatPass);
        int insert = userMapper.insert(user);
        if (insert == 0) {
            throw new AuthorityException(
                    ResponseStatus.EXCEPTION_STATUS_702.getCode(), ResponseStatus.EXCEPTION_STATUS_702.getMsg());
        }
        return ResponseResult.success(Maps.newHashMap(), 0);
        
    }
}