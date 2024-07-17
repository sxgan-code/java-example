package cn.sxgan.base.auth.services.impl;

import cn.sxgan.base.auth.entity.UserSessionInfo;
import cn.sxgan.base.auth.services.ISysUserService;
import cn.sxgan.common.entity.SysUser;
import cn.sxgan.common.entity.converts.SysUserConvert;
import cn.sxgan.common.entity.query.SysUserQuery;
import cn.sxgan.common.entity.vo.SysUserVO;
import cn.sxgan.common.mappers.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户查询服务
 * @Author: sxgan
 * @Date: 24/7/12 17:39
 * @Version: 1.0
 **/
@Slf4j
@Service
public class UserServiceImpl implements ISysUserService {
    
    @Resource
    SysUserMapper userMapper;
    
    @Override
    public SysUserVO selectSysUserInfo(UserSessionInfo currentUser) {
        SysUserVO sysUserVO = new SysUserVO();
        if (currentUser == null || StringUtils.isBlank(currentUser.getEmail())) {
            return sysUserVO;
        }
        SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setEmail(currentUser.getEmail());
        List<SysUser> sysUsers = userMapper.selectUserByCondition(sysUserQuery);
        if (!sysUsers.isEmpty()) {
            sysUserVO = SysUserConvert.INSTANCE.sysUserToVO(sysUsers.getFirst());
        } else {
            return null;
        }
        return sysUserVO;
    }
    
    @Override
    public String updateSysUserInfo(SysUserVO sysUserVO) {
        if (sysUserVO == null || StringUtils.isBlank(sysUserVO.getEmail())) {
            return null;
        }
        SysUser sysUser = SysUserConvert.INSTANCE.sysUserVOToDAO(sysUserVO);
        
        int bool = userMapper.update(sysUser,
                new UpdateWrapper<SysUser>()
                        .eq("email", sysUser.getEmail())
                        .set("user_name", sysUser.getUserName())
                        .set("personal_sign", sysUser.getPersonalSign()));
        return bool > 0 ? "用户更新完成" : null;
    }
}