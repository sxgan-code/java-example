package cn.sxgan.base.auth.services;

import cn.sxgan.base.auth.entity.UserSessionInfo;
import cn.sxgan.common.entity.vo.SysUserVO;

/**
 * @Description: 系统用户服务接口
 * @Author: sxgan
 * @Date: 24/7/12 17:39
 * @Version: 1.0
 **/
public interface ISysUserService {
    /**
     * 通过邮箱查询用户
     *
     * @param currentUser 当前登录用户
     * @return 用户视图对象
     */
    SysUserVO selectSysUserInfo(UserSessionInfo currentUser);
    
    /**
     * 通过邮箱更新用户
     *
     * @param sysUserVO 用户视图对象
     * @return 更新结果
     */
    String updateSysUserInfo(SysUserVO sysUserVO);
}